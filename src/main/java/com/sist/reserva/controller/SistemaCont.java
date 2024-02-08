package com.sist.reserva.controller;

import com.sist.reserva.controller.handleEx.ObjetoNoContentException;
import com.sist.reserva.controller.handleEx.ObjetoNotFoundException;
import com.sist.reserva.reservas.mapper.IReservasMapper;
import com.sist.reserva.reservas.dto.ReservaUpdate;
import com.sist.reserva.reservas.dto.ReservasByServicio;
import com.sist.reserva.reservas.dto.ReservasByUsuario;
import com.sist.reserva.reservas.dto.ReservasFindAll;
import com.sist.reserva.reservas.dto.ReservasFindId;
import com.sist.reserva.reservas.dto.ReservasSave;
import com.sist.reserva.reservas.entity.Reservas;
import com.sist.reserva.reservas.service.IReservasService;
import com.sist.reserva.servicios.dto.IServiciosConPreciosMenores;
import com.sist.reserva.servicios.dto.IServiciosDisponibles;
import com.sist.reserva.servicios.dto.IServiciosPorCategoria;
import com.sist.reserva.servicios.dto.IServiciosPorDuracion;
import com.sist.reserva.servicios.dto.IServiciosPorUbicacion;
import com.sist.reserva.servicios.dto.ServiciosAllList;
import com.sist.reserva.servicios.dto.ServiciosUpdate;
import com.sist.reserva.servicios.entity.DisponibilidadServicio;
import com.sist.reserva.servicios.entity.Servicios;
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

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
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
  @Autowired
  private IReservasService reservasService;

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

    return ResponseEntity.ok(serviciosReservadosLists);
  }

  // Obtener Usuarios con Reservas Pendientes
  @GetMapping("/usuarios/reservas-pendientes")
  public ResponseEntity<?> findReservasPendientes() {
    List<ReservasPendientesList> reservasPendientesLists = usuarioService.findUsuariosConReservasPendientes();
    return ResponseEntity.ok(reservasPendientesLists);
  }

  // Obtener Usuarios Registrados en un Rango de Fechas
  @GetMapping("/usuarios/reservas/rango-fechas")
  public ResponseEntity<?> findUsuariosInRangeDate(
      @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
      @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
    List<UsuariosPorRangoFechasList> usuariosPorRangoFechasLists = usuarioService
        .findUsuariosByFechaRegistroBetween(fechaInicio, fechaFin);
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

  // listar todos los servicios
  @GetMapping("/servicios")
  public ResponseEntity<?> allServicios() {
    List<ServiciosAllList> listaTodosLosServicios = IServiciosMapper.INSTANCE.toAllListDTO(serviciosService.findAll());

    return ResponseEntity.ok(listaTodosLosServicios);
  }

  // listar servicio por id
  @GetMapping("/servicios/{id}")
  public ResponseEntity<?> findServicioById(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    }
    Optional<Servicios> servOp = serviciosService.findById(id);
    if (!servOp.isPresent()) {
      throw new ObjetoNoContentException("El servicio " + id + " NO existe");
    }
    Servicios servicioEncontrado = servOp.get();
    ServiciosAllList servicioId = IServiciosMapper.INSTANCE.map(servicioEncontrado);
    return ResponseEntity.ok(servicioId);
  }

  // listar por categoria
  @GetMapping("/servicios/categoria/{categoria}")
  public ResponseEntity<?> findCategoria(@PathVariable String categoria) {
    List<IServiciosPorCategoria> serviciosPorCategorias = serviciosService.findByCategoria(categoria);
    return ResponseEntity.ok(serviciosPorCategorias);
  }

  // servicios segun su disponibilidad
  @GetMapping("/servicios/disponibles/{disponibilidad}")
  public ResponseEntity<?> findDisponibles(@PathVariable String disponibilidad) {
    DisponibilidadServicio disponible = IServiciosMapper.INSTANCE.mapToEnum(disponibilidad);
    List<IServiciosDisponibles> serviciosDisponibles = serviciosService.findServiciosByDisponible(disponible);
    return ResponseEntity.ok(serviciosDisponibles);
  }

  // obtener servicios por ubicación
  @GetMapping("/servicios/ubicacion/{ubicacion}")
  public ResponseEntity<?> findByUbicacion(@PathVariable String ubicacion) {
    if (ubicacion == null) {
      return ResponseEntity.notFound().build();
    }
    List<IServiciosPorUbicacion> serviciosPorUbicacions = serviciosService.findServiciosByUbicacion(ubicacion);
    return ResponseEntity.ok(serviciosPorUbicacions);
  }

  // Obtener Servicios con Duración Específica
  @GetMapping("/servicios/duracion/{duracion}")
  public ResponseEntity<?> findByDuracion(@PathVariable String duracion) {
    // convertir a tipo Duration
    Duration duration = Duration.parse("PT" + duracion);
    // crear la lista de proyeccion
    List<IServiciosPorDuracion> serviciosPorDuracions = serviciosService.findServiciosByDuracion(duration);
    return ResponseEntity.ok(serviciosPorDuracions);
  }

  // Obtener Servicios con Precio Menor a un Valor
  @GetMapping("/servicios/precio-menos-que/{precio}")
  public ResponseEntity<?> findByPrecio(@PathVariable BigDecimal precio) {
    if (precio == null) {
      return ResponseEntity.noContent().build();
    }
    List<IServiciosConPreciosMenores> preciosMenores = serviciosService.findServiciosByPrecioLessThan(precio);
    return ResponseEntity.ok(preciosMenores);
  }

  // guardar servicio
  @PostMapping("/servicios/guardar")
  public ResponseEntity<?> saveServicio(@RequestBody @Valid ServiciosUpdate serviciosSave) throws URISyntaxException {
    Servicios servicios = IServiciosMapper.INSTANCE.toEnt(serviciosSave);
    serviciosService.save(servicios);
    return ResponseEntity.created(new URI("/sistReserva/servicios/guardar"))
        .body("Servicio " + serviciosSave.getNombre() + " guardado");
  }

  // actualizar servicio
  @PutMapping("/servicios/actualizar/{id}")
  public ResponseEntity<?> updateServicio(@PathVariable Long id, @RequestBody @Valid ServiciosUpdate serviciosUpdate) {
    Optional<Servicios> serOp = serviciosService.findById(id);
    if (!serOp.isPresent()) {
      throw new ObjetoNotFoundException("El Servicio " + id + "NO se puede actualizar");
    }
    serviciosUpdate.setId(id);
    serviciosService.update(serviciosUpdate);
    return ResponseEntity.ok("Servicio " + serviciosUpdate.getNombre() + " actualizado");
  }

  // eliminar un servicio por su id
  @DeleteMapping("/servicios/eliminar/{id}")
  public ResponseEntity<?> deleteServicio(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    }
    Optional<Servicios> serOp = serviciosService.findById(id);
    if (!serOp.isPresent()) {
      throw new ObjetoNotFoundException("No se puede eliminar el servicio " + id);
    }
    serviciosService.deleteById(id);
    return ResponseEntity.ok("Servicio " + id + " eliminado");
  }
  /*
   * ---------------------
   *
   *
   * | PARTE DE RESERVAS |
   *
   *
   * ---------------------
   */

  // todas las reservas
  @GetMapping("/reservas")
  public ResponseEntity<?> findAllReservas() {
    List<ReservasFindAll> todasLasReservas = IReservasMapper.INSTANCE.toListAll(reservasService.findAll());

    return ResponseEntity.ok(todasLasReservas);
  }

  // por id
  @GetMapping("/reservas/{id}")
  public ResponseEntity<?> findByIdReserva(@PathVariable Long id) {
    Optional<Reservas> reservaOP = reservasService.findById(id);
    if (!reservaOP.isPresent()) {
      throw new ObjetoNotFoundException("La reserva " + id + "no existe");
    }
    Reservas reservaId = reservaOP.get();
    ReservasFindId reservaEncontrada = IReservasMapper.INSTANCE.toId(reservaId);
    return ResponseEntity.ok(reservaEncontrada);
  }

  // Obtener Reservas por Usuario
  @GetMapping("/reservas/usuario/{nombre}")
  public ResponseEntity<?> findByNombre(@PathVariable String nombre) {
    List<ReservasByUsuario> reservasUsuarios = reservasService.findUsuarioNombre(nombre);
    return ResponseEntity.ok(reservasUsuarios);
  }

  // Obtener Reservas por Servicio
  @GetMapping("/reservas/servicios/{nombre}")
  public ResponseEntity<?> findByServicio(@PathVariable String nombre) {
    List<ReservasByServicio> rByServicios = reservasService.findServicioNombre(nombre);
    return ResponseEntity.ok(rByServicios);
  }

  // Obtener Reservas en un Rango de Fechas
  @GetMapping("/reservas/rango-fechas")
  public ResponseEntity<?> findByRangoFechas(
      @RequestParam("inicioRangoInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicioRangoInicio,
      @RequestParam("finRangoInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finRangoInicio,
      @RequestParam("inicioRangoFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicioRangoFin,
      @RequestParam("finRangoFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finRangoFin) {
    List<ReservasFindAll> findAlls = IReservasMapper.INSTANCE
        .toListAll(reservasService.findReservasByFechaInicioBetweenAndFechaFinBetween(
            inicioRangoInicio, finRangoInicio, inicioRangoFin, finRangoFin));
    return ResponseEntity.ok(findAlls);
  }

  // Obtener Reservas por Estado
  @GetMapping("/reservas/estado/{estado}")
  public ResponseEntity<?> findByEstado(@PathVariable String estado) {
    if (estado == null) {
      return ResponseEntity.notFound().build();
    }
    List<ReservasFindAll> findAlls = IReservasMapper.INSTANCE
        .toListAll(reservasService.findReservasByEstado(IReservasMapper.INSTANCE.toEnum(estado)));
    return ResponseEntity.ok(findAlls);
  }

  // Obtener Reservas con un Número Específico de Personas
  @GetMapping("/reservas/numero-personas/{numero}")
  public ResponseEntity<?> findByNumeroPersonas(@PathVariable int numero) {
    List<ReservasFindAll> findAlls = IReservasMapper.INSTANCE
        .toListAll(reservasService.findReservasByNumPersonas(numero));
    return ResponseEntity.ok(findAlls);
  }

  // guardar
  @PostMapping("/reservas/guardar")
  public ResponseEntity<?> saveReserva(@RequestBody @Valid ReservasSave reservasSave) throws URISyntaxException {
    Reservas nuevaReserva = new Reservas();

    nuevaReserva.setUsuario(usuarioService.findByNombre(reservasSave.getUsuarioNombre()));
    nuevaReserva.setServicio(serviciosService.findByNombre(reservasSave.getServicioNombre()));
    nuevaReserva.setEstado(IReservasMapper.INSTANCE.toEnum(reservasSave.getEstado()));
    nuevaReserva.setNumPersonas(reservasSave.getNumPersonas());
    nuevaReserva.setFechaInicio(reservasSave.getFechaInicio());
    nuevaReserva.setFechaFin(reservasSave.getFechaFin());
    nuevaReserva.setNotas(reservasSave.getNotas());

    reservasService.save(nuevaReserva);
    return ResponseEntity.created(new URI("/sistReserva/reservas/guardar"))
        .body("Reserva de usuario " + reservasSave.getUsuarioNombre() + " guardada");
  }

  // actualizar
  @PutMapping("/reservas/actualizar/{id}")
  public ResponseEntity<?> updateReserva(@PathVariable Long id, @RequestBody @Valid ReservaUpdate reservaUpdate) {
    if (id == null) {
      throw new ObjetoNotFoundException("La reserva " + id + " no se puede actualizar");
    }
    var reservaOp = reservasService.findById(id);
    if (!reservaOp.isPresent()) {
      throw new ObjetoNotFoundException("La reserva no se puede actualizar");
    }
    reservaUpdate.setId(id);
    reservasService.update(reservaUpdate);
    return ResponseEntity.ok("Reserva " + id + " actualizada, de usuario " + reservaUpdate.getUsuarioId());
  }

  // eliminar
  @DeleteMapping("/reservas/eliminar/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    }
    var reservaOP = reservasService.findById(id);
    if (!reservaOP.isPresent()) {
      throw new ObjetoNotFoundException("La reserva no se puede eliminar");
    }
    reservasService.deleteById(id);
    return ResponseEntity.ok("Reserva " + id + " eliminada");
  }
}
