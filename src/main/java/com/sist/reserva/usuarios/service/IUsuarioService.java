package com.sist.reserva.usuarios.service;

import com.sist.reserva.usuarios.dto.ReservasDeUsuarioList;
import com.sist.reserva.usuarios.dto.ReservasPendientesList;
import com.sist.reserva.usuarios.dto.ServiciosReservadosPorUsuarioList;
import com.sist.reserva.usuarios.dto.UsuarioUpdate;
import com.sist.reserva.usuarios.dto.UsuariosPorRangoFechasList;
import com.sist.reserva.usuarios.entity.Usuarios;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
  // listar todos
  List<Usuarios> findAll();

  // Obtener un Usuario por ID
  Optional<Usuarios> findById(Long id);

  // Obtener las Reservas de un Usuario
  List<ReservasDeUsuarioList> findReservasByUsuarioId(Long usuarioId);

  // Obtener Servicios Reservados por un Usuario
  List<ServiciosReservadosPorUsuarioList> findServiciosReservadosByUsuarioId(Long usuarioId);

  // Obtener Usuarios con Reservas Pendientes
  List<ReservasPendientesList> findUsuariosConReservasPendientes();

  // Obtener Usuarios Registrados en un Rango de Fechas
  List<UsuariosPorRangoFechasList> findUsuariosByFechaRegistroBetween(
      LocalDate fechaInicio, LocalDate fechaFin);

  // encontrar por nombre
  Usuarios findByNombre(String nombre);

  // guardar
  void save(Usuarios usuario);

  // actualizar
  void update(UsuarioUpdate usuario);

  // eliminar
  void deleteById(Long id);
}
