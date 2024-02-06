package com.sist.reserva.reservas.repository;

import com.sist.reserva.reservas.dto.ReservaUpdate;
import com.sist.reserva.reservas.dto.ReservasByServicio;
import com.sist.reserva.reservas.dto.ReservasByUsuario;
import com.sist.reserva.reservas.entity.EstadoReserva;
import com.sist.reserva.reservas.entity.Reservas;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IReservasRepository extends JpaRepository<Reservas, Long> {

  // Obtener una Reserva por ID
  Optional<Reservas> findById(Long id);

  // Obtener Reservas por Usuario
  List<ReservasByUsuario> findByUsuarioNombre(String nombre);

  // Obtener Reservas por Servicio
  List<ReservasByServicio> findByServicioNombre(String nombre);

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

  // actualizar
  @Query("UPDATE Reservas v SET v.usuario.id = :#{#reserva.usuarioId}, v.numPersonas ="
      + " :#{#reserva.numPersonas}, v.servicio.id = :#{#reserva.servicioId}, v.fechaInicio ="
      + " :#{#reserva.fechaInicio}, v.fechaFin = :#{#reserva.fechaFin}, v.estado ="
      + " :#{#reserva.estado}, v.notas = :#{#reserva.notas} WHERE v.id = :#{#reserva.id}")
  @Transactional
  @Modifying
  void update(ReservaUpdate reserva);
}
