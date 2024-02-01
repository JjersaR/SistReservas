package com.sist.reserva.reservas.service.impl;

import com.sist.reserva.reservas.dao.IReservasDAO;
import com.sist.reserva.reservas.dto.ReservaUpdate;
import com.sist.reserva.reservas.entity.Reservas;
import com.sist.reserva.reservas.service.IReservasService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservasServiceImpl implements IReservasService {

  @Autowired
  private IReservasDAO reservasDAO;

  @Override
  public List<Reservas> findAll() {
    return reservasDAO.findAll();
  }

  @Override
  public Optional<Reservas> findById(Long id) {
    return reservasDAO.findById(id);
  }

  @Override
  public List<Reservas> findUsuarioNombre(String nombre) {
    return reservasDAO.findUsuarioNombre(nombre);
  }

  @Override
  public List<Reservas> findServicioNombre(String nombre) {
    return reservasDAO.findServicioNombre(nombre);
  }

  @Override
  public List<Reservas> findReservasByFechaInicioBetweenAndFechaFinBetween(
      LocalDate inicioRangoInicio,
      LocalDate finRangoInicio,
      LocalDate inicioRangoFin,
      LocalDate finRangoFin) {
    return reservasDAO.findReservasByFechaInicioBetweenAndFechaFinBetween(
        inicioRangoInicio, finRangoInicio, inicioRangoFin, finRangoFin);
  }

  @Override
  public List<Reservas> findReservasByEstado(String estado) {
    return reservasDAO.findReservasByEstado(estado);
  }

  @Override
  public List<Reservas> findReservasByNumPersonas(int numeroPersonas) {
    return reservasDAO.findReservasByNumPersonas(numeroPersonas);
  }

  @Override
  public void save(Reservas reserva) {
    reservasDAO.save(reserva);
  }

  @Override
  public void update(ReservaUpdate reserva) {
    reservasDAO.update(reserva);
  }

  @Override
  public void deleteById(Long id) {
    reservasDAO.deleteById(id);
  }
}
