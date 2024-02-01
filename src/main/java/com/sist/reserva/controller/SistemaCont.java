package com.sist.reserva.controller;

import com.sist.reserva.servicios.dto.ServiciosAllList;
import com.sist.reserva.servicios.mapper.IServiciosMapper;
import com.sist.reserva.servicios.service.IServiciosService;
import com.sist.reserva.usuarios.dto.ReservasDeUsuarioList;
import com.sist.reserva.usuarios.dto.ReservasPendientesList;
import com.sist.reserva.usuarios.dto.ServiciosReservadosPorUsuarioList;
import com.sist.reserva.usuarios.dto.UsuarioById;
import com.sist.reserva.usuarios.dto.UsuarioListAll;
import com.sist.reserva.usuarios.dto.UsuarioSave;
import com.sist.reserva.usuarios.dto.UsuarioUpdate;
import com.sist.reserva.usuarios.dto.UsuariosPorRangoFechasList;
import com.sist.reserva.usuarios.entity.Usuarios;
import com.sist.reserva.usuarios.mapper.IUsuarioMapper;
import com.sist.reserva.usuarios.service.IUsuarioService;

import jakarta.validation.Valid;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sistReserva")
public class SistemaCont {

  @Autowired
  private IUsuarioService usuarioService;
  @Autowired
  private IServiciosService serviciosService;

  // listar todos
  @GetMapping("/usuarios")
  public ResponseEntity<?> findAllUsuarios() {
    List<UsuarioListAll> listAlls = IUsuarioMapper.INSTANCE.toAllUsuariosListDTO(usuarioService.findAll());

    if (listAlls.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(listAlls);
  }

  // Obtener un Usuario por ID
  @GetMapping("/usuarios/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    }

    Optional<Usuarios> usuOp = usuarioService.findById(id);
    if (usuOp.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Usuarios usuarios = usuOp.get();
    UsuarioById usuarioById = IUsuarioMapper.INSTANCE.toUsuarioIdDTO(usuarios);
    return ResponseEntity.ok(usuarioById);
  }

  // Obtener las Reservas de un Usuario
  @GetMapping("/usuarios/{id}/reservas")
  public ResponseEntity<?> findReservasByUsuarioId(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    }

    List<ReservasDeUsuarioList> reservasDeUsuarioLists = usuarioService.findReservasByUsuarioId(id);
    if (reservasDeUsuarioLists.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(reservasDeUsuarioLists);
  }

  // Obtener Servicios Reservados por un Usuario
  @GetMapping("/usuarios/{id}/servicios-reservados")
  public ResponseEntity<?> findServiciosByUsuarioId(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    }

    List<ServiciosReservadosPorUsuarioList> serviciosReservadosLists = usuarioService
        .findServiciosReservadosByUsuarioId(id);
    if (serviciosReservadosLists.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(serviciosReservadosLists);
  }

  // Obtener Usuarios con Reservas Pendientes
  @GetMapping("/usuarios/reservas-pendientes")
  public ResponseEntity<?> findReservasPendientes() {
    List<ReservasPendientesList> reservasPendientesLists = usuarioService.findUsuariosConReservasPendientes();
    if (reservasPendientesLists.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(reservasPendientesLists);
  }

  // Obtener Usuarios Registrados en un Rango de Fechas
  @GetMapping("/usuarios/reservas/rango-fechas")
  public ResponseEntity<?> findUsuariosInRangeDate(
      @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
      @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
    List<UsuariosPorRangoFechasList> usuariosPorRangoFechasLists = usuarioService
        .findUsuariosByFechaRegistroBetween(fechaInicio, fechaFin);
    if (usuariosPorRangoFechasLists.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(usuariosPorRangoFechasLists);
  }

  // guardar
  @PostMapping("/usuarios/guardar")
  public ResponseEntity<?> save(@RequestBody @Valid UsuarioSave usuarioSave) throws URISyntaxException {
    Usuarios usuario = IUsuarioMapper.INSTANCE.toUsuarioSave(usuarioSave);
    usuarioService.save(usuario);
    return ResponseEntity.created(new URI("/sistReserva/usuarios/guardar"))
        .body("Usuario " + usuarioSave.getTelefono() + " creado");
  }

  // actualizar
  @PutMapping("/usuarios/actualizar/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UsuarioUpdate usuUpdate) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    }
    usuUpdate.setId(id);
    usuarioService.update(usuUpdate);
    return ResponseEntity.ok("Usuario " + id + " actualizado");
  }

  // eliminar usuario
  @DeleteMapping("/usuarios/eliminar/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.noContent().build();
    }
    Optional<Usuarios> usOp = usuarioService.findById(id);
    if (!usOp.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    usuarioService.deleteById(id);
    return ResponseEntity.ok("Usuario " + id + " eliminado");
  }

  /*
   * ------------------------
   *
   *
   * | PARTE DE SERVICIOS |
   *
   *
   * ------------------------
   */

  @GetMapping("/servicios")
  public ResponseEntity<?> allServicios() {
    List<ServiciosAllList> listaTodosLosServicios = IServiciosMapper.INSTANCE.toAllListDTO(serviciosService.findAll());
    if (listaTodosLosServicios.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(listaTodosLosServicios);
  }
}
