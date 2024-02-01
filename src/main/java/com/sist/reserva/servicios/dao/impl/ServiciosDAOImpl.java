package com.sist.reserva.servicios.dao.impl;

import com.sist.reserva.servicios.dao.IServiciosDAO;
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
  public List<Servicios> findByCategoria(String categoria) {
    return serviciosRepository.findByCategoria(categoria);
  }

  @Override
  public List<Servicios> findServiciosByDisponible(DisponibilidadServicio disponible) {
    return serviciosRepository.findServiciosByDisponible(disponible);
  }

  @Override
  public List<Servicios> findServiciosByUbicacion(String ubicacion) {
    return serviciosRepository.findServiciosByUbicacion(ubicacion);
  }

  @Override
  public List<Servicios> findServiciosByDuracion(Duration duracion) {
    return serviciosRepository.findServiciosByDuracion(duracion);
  }

  @Override
  public List<Servicios> findServiciosByPrecioLessThan(BigDecimal precio) {
    return serviciosRepository.findServiciosByPrecioLessThan(precio);
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
}
