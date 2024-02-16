# Tour por Proyecto SistReservas

## Estructura de PURAS Carpetas
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── sist
│   │   │           └── reserva
│   │   │               ├── config
│   │   │               ├── controller
│   │   │               │   └── handleEx
│   │   │               ├── reservas
│   │   │               │   ├── dao
│   │   │               │   │   └── impl
│   │   │               │   ├── dto
│   │   │               │   ├── entity
│   │   │               │   ├── mapper
│   │   │               │   ├── repository
│   │   │               │   └── service
│   │   │               │       └── impl
│   │   │               ├── servicios
│   │   │               │   ├── dao
│   │   │               │   │   └── impl
│   │   │               │   ├── dto
│   │   │               │   ├── entity
│   │   │               │   ├── mapper
│   │   │               │   ├── repository
│   │   │               │   └── service
│   │   │               │       └── impl
│   │   │               └── usuarios
│   │   │                   ├── dao
│   │   │                   │   └── impl
│   │   │                   ├── dto
│   │   │                   ├── entity
│   │   │                   ├── mapper
│   │   │                   ├── repository
│   │   │                   └── service
│   │   │                       └── impl
___
# Numero de Tablas del Proyecto

Existen 3 tablas en el manejador de bases de datos SQL Server:
- Reservas (Tiene relación con Servicios y Usuarios)
- Servicios
- Usuarios (Tiene relación con Reservas para listar las reservas del usuario)

## TABLAS

### Clase/Tabla Reservas
``` java
// Reservas
@Entity
public class Reservas {
  private Long id;
  private Usuarios usuario; // gracias a esta variable existe una relación con Usuarios
  private int numPersonas;
  private Servicios servicio; // gracias a esta variable existe una relación con Servicios
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private EstadoReserva estado;
  private String notas;
}
```
El tipo de dato EstadoReserva es un enum con estos datos:
``` java
public enum EstadoReserva {
  PENDIENTE,
  CONFIRMADA,
  CANCELADA,
  COMPLETADA,
  EN_PROGRESO,
  NO_SHOW,
  REPROGRAMABLE
}
```

### Clase/Tabla Servicios
``` java
@Entity
public class Servicios {
  private Long id;
  private String nombre;
  private BigDecimal precio;
  private String categoria;
  private Duration duracion;
  private DisponibilidadServicio disponible;
  private String ubicacion;
  private String descripcion;
}
```
El tipo de dato DisponibilidadServicio es un enum con estos datos:
``` java
public enum DisponibilidadServicio {
  DISPONIBLE,
  RESERVADO,
  MANTENIMIENTO,
  NO_DISPONIBLE
}
```

### Clase/Tabla Usuarios
```java
@Entity
public class Usuarios {
  private Long id;
  private LocalDate fechaRegistro;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String correo;
  private String telefono;
  private List<Reservas> reservas; // con esta variable se puede imprimir las reservas del usuario
}
```

# Qué puede hacer cada tabla?

## Repository de Reservas
```java
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

```

## Repositoy de Servicios
```java
  // listar todos
  List<Servicios> findAll();

  // Obtener un Servicio por ID
  Optional<Servicios> findById(Long id);

  // Obtener Servicios por Categoría
  List<IServiciosPorCategoria> findByCategoria(String categoria);

  // Obtener Servicios Disponibles
  List<IServiciosDisponibles> findServiciosByDisponible(DisponibilidadServicio disponible);

  // Obtener Servicios por Ubicación
  List<IServiciosPorUbicacion> findServiciosByUbicacion(String ubicacion);

  // Obtener Servicios con Duración Específica
  List<IServiciosPorDuracion> findServiciosByDuracion(Duration duracion);

  // Obtener Servicios con Precio Menor a un Valor
  List<IServiciosConPreciosMenores> findServiciosByPrecioLessThan(BigDecimal precio);

  // obtener por nombre
  Servicios findByNombre(String nombre);

  // guardar
  void save(Servicios servicio);

  // actualizar
  void update(ServiciosUpdate servicio);

  // eliminar
  void deleteById(Long id);

```

## Repositoy de Usuarios

```java
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

```
# Proyecciones
No se mostrarán todas, pero se usan proyecciones cerradas con interfaces, por ejemplo:
```java
public interface UsuariosPorRangoFechasList {

  String getUsuarioNombre();

  LocalDate getFechaRegistro();

  String getCorreo();

  String getTelefono();
}
```

# MapStruct
Dentro de cada carpeta hay una carpeta que se llama mapper/I*Mapper.java
Por ejemplo el mapeador de la tabla/clase de Servicios se ve así:

```java
@Mapper
public interface IServiciosMapper {

  IServiciosMapper INSTANCE = Mappers.getMapper(IServiciosMapper.class);

  // listar todos
  List<ServiciosAllList> toAllListDTO(List<Servicios> servicios);

  ServiciosAllList map(Servicios value);

  DisponibilidadServicio mapToEnum(String disponibilidad);

  // de ServiciosUpdate a Servicios
  Servicios toEnt(ServiciosUpdate serviciosUpdate);
}
```
# Exception Handler

## Clase que lo maneja
```java
@ControllerAdvice
public class SistReservasExceptionHandler {

  // CUANDO EL OBJETO NO SE ENCUENTRA
  @ExceptionHandler(ObjetoNotFoundException.class)
  public ResponseEntity<Object> handlerObjetoNotFoundException(
      ObjetoNotFoundException notFoundException) {

    SistReservasException sistReservasException = new SistReservasException(
        notFoundException.getMessage(), notFoundException.getCause(), HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(sistReservasException, HttpStatus.NOT_FOUND);
  }

  // CUANDO EL OBJETO NO TIENE NADA
  @ExceptionHandler(ObjetoNoContentException.class)
  public ResponseEntity<Object> handlerObjetoNoContentException(ObjetoNoContentException noContentException) {
    SistReservasException sistReservasException = new SistReservasException(
            noContentException.getMessage(), noContentException.getCause(), HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(sistReservasException, HttpStatus.NO_CONTENT);
  }
}
```

# Peticiones HTTP

## Reservas
```http
# mostrar todas las reservas
GET http://localhost:8080/sistReserva/reservas

# mostrar por id
GET http://localhost:8080/sistReserva/reservas/27

# mostrar por nombre de usuario
GET http://localhost:8080/sistReserva/reservas/usuario/Carlos

# mostrar por nombre de servicios
GET http://localhost:8080/sistReserva/reservas/servicios/Posada

# rango de fechas
GET http://localhost:8080/sistReserva/reservas/rango-fechas?inicioRangoInicio=2024-02-01&finRangoInicio=2024-02-05&inicioRangoFin=2024-03-05&finRangoFin=2024-03-05

# mostrar por estado {PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA, EN_PROGRESO, NO_SHOW, REPROGRAMABLE}
GET http://localhost:8080/sistReserva/reservas/estado/PENDIENTE

# mostrar por numero de personas
GET http://localhost:8080/sistReserva/reservas/numero-personas/5

# guardar reserva
POST http://localhost:8080/sistReserva/reservas/guardar
Content-Type: application/json

{
  "usuarioNombre": "Ana",
  "numPersonas": 2,
  "servicioNombre": "Pensión",
  "fechaInicio": "2024-02-05",
  "fechaFin": "2024-04-01",
  "estado": "NO_SHOW",
  "notas": ""
}

# ver id´ś de servicios
GET http://localhost:8080/sistReserva/servicios
# ver id´s de usuarios
GET http://localhost:8080/sistReserva/usuarios
# actualizar
PUT http://localhost:8080/sistReserva/reservas/actualizar/27
Content-Type: application/json

{
  "usuarioId": 16,
  "numPersonas": 5,
  "servicioId": 32,
  "fechaInicio": "2024-02-04",
  "fechaFin": "2024-04-25",
  "estado": "COMPLETADA",
  "notas": "Pagara en 2 semanas"
}

# eliminar reserva
DELETE http://localhost:8080/sistReserva/reservas/eliminar/27
```

## Servicios
```http
# mostrar todos los servicios
GET http://localhost:8080/sistReserva/servicios

# mostrar servicio por id
GET http://localhost:8080/sistReserva/servicios/37

# mostrar servicios por categoria
GET http://localhost:8080/sistReserva/servicios/categoria/Streaming

# mostrar segun el campo disponible {DISPONIBLE, RESERVADO, MANTENIMIENTO, NO_DISPONIBLE}
GET http://localhost:8080/sistReserva/servicios/disponibles/MANTENIMIENTO

# mostrar segun su ubicacion
GET http://localhost:8080/sistReserva/servicios/ubicacion/Tijuana

# mostrar segun su duracion
GET http://localhost:8080/sistReserva/servicios/duracion/0.000000003S

# guardar un servicio
POST http://localhost:8080/sistReserva/servicios/guardar
Content-Type: application/json

{
  "nombre": "Spotify",
  "precio": 110.00,
  "categoria": "Streaming",
  "duracion": 150,
  "disponible": "NO_DISPONIBLE",
  "ubicacion": "CDMX",
  "descripcion": "Escuchar musica sin anuncios"
}

# actualizar
PUT http://localhost:8080/sistReserva/servicios/actualizar/47
Content-Type: application/json

{
  "nombre": "Spotify",
  "precio": 150.00,
  "categoria": "Streaming",
  "duracion": 250,
  "disponible": "RESERVADO",
  "ubicacion": "CDMX",
  "descripcion": "Escuchar musica sin anuncios y sin conexion a internet"
}

# Borrar
DELETE http://localhost:8080/sistReserva/servicios/eliminar/47

```

## Usuarios
```http
# mostrar todos los usuarios
GET http://localhost:8080/sistReserva/usuarios

# mostrar usuario por ID
GET http://localhost:8080/sistReserva/usuarios/31

# mostrar reservas de usuario
GET http://localhost:8080/sistReserva/usuarios/20/reservas

# mostrar reservas pendientes
GET http://localhost:8080/sistReserva/usuarios/reservas-pendientes

# usuarios agregados dentro de un rango de fechas
GET http://localhost:8080/sistReserva/usuarios/reservas/rango-fechas?fechaInicio=2023-12-30&fechaFin=2024-01-31

# guardar
POST http://localhost:8080/sistReserva/usuarios/guardar
Content-Type: application/json

{
  "fechaRegistro": "2024-02-01",
  "nombre": "R",
  "apellidoPaterno": "S",
  "apellidoMaterno": "J",
  "correo": ""
}

# actualizar
PUT http://localhost:8080/sistReserva/usuarios/actualizar/31
Content-Type: application/json

{
  "nombre": "R",
  "apellidoPaterno": "S",
  "apellidoMaterno": "J",
  "correo": "",
  "telefono": ""
}

# Borrar
DELETE http://localhost:8080/sistReserva/usuarios/eliminar/31
```

# Funcionamiento
![Funcionamiento](/Imagenes/SistReservasHttp.jpeg)
