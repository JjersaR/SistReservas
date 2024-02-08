package com.sist.reserva.reservas.service.impl;

import com.sist.reserva.controller.handleEx.ObjetoNoContentException;
import com.sist.reserva.controller.handleEx.ObjetoNotFoundException;
import com.sist.reserva.reservas.dao.IReservasDAO;
import com.sist.reserva.reservas.dto.ReservaUpdate;
import com.sist.reserva.reservas.dto.ReservasByServicio;
import com.sist.reserva.reservas.dto.ReservasByUsuario;
import com.sist.reserva.reservas.entity.EstadoReserva;
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
    if (reservasDAO.findAll().isEmpty())
      throw new ObjetoNoContentException("Lista de Reservas Vacia");
    return reservasDAO.findAll();
  }

  @Override
  public Optional<Reservas> findById(Long id) {
    if (reservasDAO.findById(id).isEmpty())
      throw new ObjetoNotFoundException("Esta reserva NO existe");
    return reservasDAO.findById(id);
  }

  @Override
  public List<ReservasByUsuario> findUsuarioNombre(String nombre) {
    if (reservasDAO.findUsuarioNombre(nombre).isEmpty())
      throw new ObjetoNoContentException("Aun el usuario " + nombre + " no tiene reservas");
    return reservasDAO.findUsuarioNombre(nombre);
  }

  @Override
  public List<ReservasByServicio> findServicioNombre(String nombre) {
    if (reservasDAO.findServicioNombre(nombre).isEmpty())
      throw new ObjetoNoContentException("Aun no hay reservas para el servicio " + nombre);
    return reservasDAO.findServicioNombre(nombre);
  }

  @Override
  public List<Reservas> findReservasByFechaInicioBetweenAndFechaFinBetween(
      LocalDate inicioRangoInicio,
      LocalDate finRangoInicio,
      LocalDate inicioRangoFin,
      LocalDate finRangoFin) {
    if (reservasDAO.findReservasByFechaInicioBetweenAndFechaFinBetween(inicioRangoInicio, finRangoInicio, inicioRangoFin, finRangoFin).isEmpty())
      throw new ObjetoNoContentException("No hay Reservas en estas fechas");
    return reservasDAO.findReservasByFechaInicioBetweenAndFechaFinBetween(
        inicioRangoInicio, finRangoInicio, inicioRangoFin, finRangoFin);
  }

  @Override
  public List<Reservas> findReservasByEstado(EstadoReserva estado) {
    if (reservasDAO.findReservasByEstado(estado).isEmpty())
      throw new ObjetoNoContentException("No hay reservas con el estado " + estado);
    return reservasDAO.findReservasByEstado(estado);
  }

  @Override
  public List<Reservas> findReservasByNumPersonas(int numeroPersonas) {
    if (reservasDAO.findReservasByNumPersonas(numeroPersonas).isEmpty())
      throw new ObjetoNoContentException("No hay reservas con el numero de personas de " + numeroPersonas);
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
