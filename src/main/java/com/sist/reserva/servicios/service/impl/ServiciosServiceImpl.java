package com.sist.reserva.servicios.service.impl;

import com.sist.reserva.controller.handleEx.ObjetoNoContentException;
import com.sist.reserva.controller.handleEx.ObjetoNotFoundException;
import com.sist.reserva.servicios.dao.IServiciosDAO;
import com.sist.reserva.servicios.dto.IServiciosConPreciosMenores;
import com.sist.reserva.servicios.dto.IServiciosDisponibles;
import com.sist.reserva.servicios.dto.IServiciosPorCategoria;
import com.sist.reserva.servicios.dto.IServiciosPorDuracion;
import com.sist.reserva.servicios.dto.IServiciosPorUbicacion;
import com.sist.reserva.servicios.dto.ServiciosUpdate;
import com.sist.reserva.servicios.entity.DisponibilidadServicio;
import com.sist.reserva.servicios.entity.Servicios;
import com.sist.reserva.servicios.service.IServiciosService;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosServiceImpl implements IServiciosService {

  @Autowired
  private IServiciosDAO serviciosDAO;

  @Override
  public List<Servicios> findAll() {
    if (serviciosDAO.findAll().isEmpty())
      throw new ObjetoNoContentException("Lista de Servicios Vacia");
    return serviciosDAO.findAll();
  }

  @Override
  public Optional<Servicios> findById(Long id) {
    if (serviciosDAO.findById(id).isEmpty())
      throw new ObjetoNotFoundException("El servicio NO existe");
    return serviciosDAO.findById(id);
  }

  @Override
  public List<IServiciosPorCategoria> findByCategoria(String categoria) {
    if (serviciosDAO.findByCategoria(categoria).isEmpty())
      throw new ObjetoNotFoundException("Lista de la categoria: " + categoria + " vacia");
    return serviciosDAO.findByCategoria(categoria);
  }

  @Override
  public List<IServiciosDisponibles> findServiciosByDisponible(DisponibilidadServicio disponible) {
    if (serviciosDAO.findServiciosByDisponible(disponible).isEmpty())
      throw new ObjetoNoContentException("La lista dada por la disponibilidad: " + disponible + " esta vacia");
    return serviciosDAO.findServiciosByDisponible(disponible);
  }

  @Override
  public List<IServiciosPorUbicacion> findServiciosByUbicacion(String ubicacion) {
    if (serviciosDAO.findServiciosByUbicacion(ubicacion).isEmpty())
      throw new ObjetoNoContentException("La lista de la ubicacion: " + ubicacion + " esta vacia");
    return serviciosDAO.findServiciosByUbicacion(ubicacion);
  }

  @Override
  public List<IServiciosPorDuracion> findServiciosByDuracion(Duration duracion) {
    if (serviciosDAO.findServiciosByDuracion(duracion).isEmpty())
      throw new ObjetoNoContentException("La lista de servicios dada la duracion " + duracion + " esta vacia");
    return serviciosDAO.findServiciosByDuracion(duracion);
  }

  @Override
  public List<IServiciosConPreciosMenores> findServiciosByPrecioLessThan(BigDecimal precio) {
    if (serviciosDAO.findServiciosByPrecioLessThan(precio).isEmpty())
      throw new ObjetoNoContentException("No hay Servicios con precios menores a " + precio);
    return serviciosDAO.findServiciosByPrecioLessThan(precio);
  }

  @Override
  public void save(Servicios servicio) {
    serviciosDAO.save(servicio);
  }

  @Override
  public void update(ServiciosUpdate servicio) {
    serviciosDAO.update(servicio);
  }

  @Override
  public void deleteById(Long id) {
    serviciosDAO.deleteById(id);
  }

  @Override
  public Servicios findByNombre(String nombre) {
    return serviciosDAO.findByNombre(nombre);
  }
}
