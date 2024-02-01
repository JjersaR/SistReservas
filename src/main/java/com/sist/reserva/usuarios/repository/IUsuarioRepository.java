package com.sist.reserva.usuarios.repository;

import com.sist.reserva.usuarios.dto.ReservasDeUsuarioList;
import com.sist.reserva.usuarios.dto.ReservasPendientesList;
import com.sist.reserva.usuarios.dto.ServiciosReservadosPorUsuarioList;
import com.sist.reserva.usuarios.dto.UsuarioUpdate;
import com.sist.reserva.usuarios.dto.UsuariosPorRangoFechasList;
import com.sist.reserva.usuarios.entity.Usuarios;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Long> {

  // Obtener un Usuario por ID
  Optional<Usuarios> findById(Long id);

  // Obtener las Reservas de un Usuario
  @Query(value = "SELECT DISTINCT u.id, CONCAT(u.nombre,' ', u.apellido_paterno, ' ', u.apellido_materno)"
      + " AS usuarioNombre, r.numero_personas AS numPersonas, s.nombre AS servicioNombre,"
      + " r.fecha_inicio AS fechaInicio, r.fecha_fin AS fechaFin, r.estado FROM Reservas r"
      + " INNER JOIN Servicios s ON r.servio_id  = s.id INNER JOIN Usuarios u ON u.id ="
      + " :id", nativeQuery = true)
  List<ReservasDeUsuarioList> reservasUsuarioById(Long id);

  // Obtener Servicios Reservados por un Usuario
  @Query(value = "SELECT CONCAT(u.nombre,' ', u.apellido_paterno, ' ', u.apellido_materno) AS"
      + " usuarioNombre, s.nombre, s.precio, s.categoria, s.duracion, s.ubicacion, r.estado"
      + " AS reservaEstado FROM Usuarios u INNER JOIN Reservas r ON u.id = r.usuario_id"
      + " INNER JOIN Servicios s ON s.id = r.servio_id WHERE u.id = :id", nativeQuery = true)
  List<ServiciosReservadosPorUsuarioList> findServiciosReservadosById(Long id);

  // Obtener Usuarios con Reservas Pendientes
  @Query(value = "SELECT DISTINCT u.id AS id, CONCAT(u.nombre,' ', u.apellido_paterno, ' ',"
      + " u.apellido_materno) AS usuarioNombre, u.telefono, u.correo FROM Usuarios u INNER"
      + " JOIN Reservas r ON u.id = r.usuario_id WHERE r.estado = 'PENDIENTE'", nativeQuery = true)
  List<ReservasPendientesList> findByReservasPendientes();

  // Obtener Usuarios Registrados en un Rango de Fechas
  @Query(value = "SELECT CONCAT(u.nombre,' ', u.apellido_paterno, ' ', u.apellido_materno) AS"
      + " usuarioNombre, u.fecha_registro AS FechaRegistro, u.correo, u.telefono FROM Usuarios u WHERE"
      + " u.fecha_registro BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
  List<UsuariosPorRangoFechasList> findUsuariosByFechaRegistroBetween(
      LocalDate fechaInicio, LocalDate fechaFin);

  // actualizar
  @Query("UPDATE Usuarios u SET u.nombre = :#{#usuario.nombre}, u.apellidoPaterno ="
      + " :#{#usuario.apellidoPaterno}, u.apellidoMaterno = :#{#usuario.apellidoMaterno},"
      + " u.correo = :#{#usuario.correo}, u.telefono = :#{#usuario.telefono} WHERE u.id ="
      + " :#{#usuario.id}")
  @Modifying
  void update(UsuarioUpdate usuario);
}
