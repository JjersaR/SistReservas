package com.sist.reserva.reservas.dao.impl;

import com.sist.reserva.reservas.dao.IReservasDAO;
import com.sist.reserva.reservas.dto.ReservaUpdate;
import com.sist.reserva.reservas.dto.ReservasByServicio;
import com.sist.reserva.reservas.dto.ReservasByUsuario;
import com.sist.reserva.reservas.entity.EstadoReserva;
import com.sist.reserva.reservas.entity.Reservas;
import com.sist.reserva.reservas.repository.IReservasRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservasDAOImpl implements IReservasDAO {

  @Autowired
  private IReservasRepository repository;

  @Override
  public List<Reservas> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Reservas> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<ReservasByUsuario> findUsuarioNombre(String nombre) {
    return repository.findByUsuarioNombre(nombre);
  }

  @Override
  public List<ReservasByServicio> findServicioNombre(String nombre) {
    return repository.findByServicioNombre(nombre);
  }

  @Override
  public List<Reservas> findReservasByFechaInicioBetweenAndFechaFinBetween(
      LocalDate inicioRangoInicio,
      LocalDate finRangoInicio,
      LocalDate inicioRangoFin,
      LocalDate finRangoFin) {
    return repository.findReservasByFechaInicioBetweenAndFechaFinBetween(
        inicioRangoInicio, finRangoInicio, inicioRangoFin, finRangoFin);
  }

  @Override
  public List<Reservas> findReservasByEstado(EstadoReserva estado) {
    return repository.findReservasByEstado(estado);
  }

  @Override
  public List<Reservas> findReservasByNumPersonas(int numeroPersonas) {
    return repository.findReservasByNumPersonas(numeroPersonas);
  }

  @Override
  public void save(Reservas reserva) {
    repository.save(reserva);
  }

  @Override
  public void update(ReservaUpdate reserva) {
    repository.update(reserva);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
