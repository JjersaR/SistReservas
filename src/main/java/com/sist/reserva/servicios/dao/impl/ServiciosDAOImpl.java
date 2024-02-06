package com.sist.reserva.servicios.dao.impl;

import com.sist.reserva.servicios.dao.IServiciosDAO;
import com.sist.reserva.servicios.dto.IServiciosConPreciosMenores;
import com.sist.reserva.servicios.dto.IServiciosDisponibles;
import com.sist.reserva.servicios.dto.IServiciosPorCategoria;
import com.sist.reserva.servicios.dto.IServiciosPorDuracion;
import com.sist.reserva.servicios.dto.IServiciosPorUbicacion;
import com.sist.reserva.servicios.dto.ServiciosUpdate;
import com.sist.reserva.servicios.entity.DisponibilidadServicio;
import com.sist.reserva.servicios.entity.Servicios;
import com.sist.reserva.servicios.repository.IServiciosRepository;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiciosDAOImpl implements IServiciosDAO {

  @Autowired
  private IServiciosRepository serviciosRepository;

  @Override
  public List<Servicios> findAll() {
    return serviciosRepository.findAll();
  }

  @Override
  public Optional<Servicios> findById(Long id) {
    return serviciosRepository.findById(id);
  }

  @Override
  public List<IServiciosPorCategoria> findByCategoria(String categoria) {
    return serviciosRepository.findByCategoria(categoria);
  }

  @Override
  public List<IServiciosDisponibles> findServiciosByDisponible(DisponibilidadServicio disponible) {
    return serviciosRepository.findByDisponible(disponible);
  }

  @Override
  public List<IServiciosPorUbicacion> findServiciosByUbicacion(String ubicacion) {
    return serviciosRepository.findByUbicacion(ubicacion);
  }

  @Override
  public List<IServiciosPorDuracion> findServiciosByDuracion(Duration duracion) {
    return serviciosRepository.findByDuracion(duracion);
  }

  @Override
  public List<IServiciosConPreciosMenores> findServiciosByPrecioLessThan(BigDecimal precio) {
    return serviciosRepository.findByPrecioLessThan(precio);
  }

  @Override
  public void save(Servicios servicio) {
    serviciosRepository.save(servicio);
  }

  @Override
  public void update(ServiciosUpdate servicio) {
    serviciosRepository.update(servicio);
  }

  @Override
  public void deleteById(Long id) {
    serviciosRepository.deleteById(id);
  }

  @Override
  public Servicios findByNombre(String nombre) {
    return serviciosRepository.findByNombre(nombre);
  }
}
