package com.sist.reserva.reservas.dao;

import com.sist.reserva.reservas.dto.ReservaUpdate;
import com.sist.reserva.reservas.dto.ReservasByServicio;
import com.sist.reserva.reservas.dto.ReservasByUsuario;
import com.sist.reserva.reservas.entity.EstadoReserva;
import com.sist.reserva.reservas.entity.Reservas;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReservasDAO {

  // listar todas las reservas
  List<Reservas> findAll();

  // Obtener una Reserva por ID
  Optional<Reservas> findById(Long id);

  // Obtener Reservas por Usuario
  List<ReservasByUsuario> findUsuarioNombre(String nombre);

  // Obtener Reservas por Servicio
  List<ReservasByServicio> findServicioNombre(String nombre);

  // Obtener Reservas en un Rango de Fechas
  List<Reservas> findReservasByFechaInicioBetweenAndFechaFinBetween(
      LocalDate inicioRangoInicio,
      LocalDate finRangoInicio,
      LocalDate inicioRangoFin,
      LocalDate finRangoFin);

  // Obtener Reservas por Estado
  List<Reservas> findReservasByEstado(EstadoReserva estado);

  // Obtener Reservas con un Número Específico de Personas
  List<Reservas> findReservasByNumPersonas(int numeroPersonas);

  // guardar
  void save(Reservas reserva);

  // actualizar
  void update(ReservaUpdate reserva);

  // eliminar por id
  void deleteById(Long id);
}
