package com.sist.reserva.reservas.mapper;

import com.sist.reserva.reservas.dto.ReservasFindAll;
import com.sist.reserva.reservas.dto.ReservasFindId;
import com.sist.reserva.reservas.dto.ReservasSave;
import com.sist.reserva.reservas.entity.EstadoReserva;
import com.sist.reserva.reservas.entity.Reservas;
import com.sist.reserva.servicios.entity.Servicios;
import com.sist.reserva.servicios.service.IServiciosService;
import com.sist.reserva.servicios.service.impl.ServiciosServiceImpl;
import com.sist.reserva.usuarios.entity.Usuarios;
import com.sist.reserva.usuarios.service.IUsuarioService;
import com.sist.reserva.usuarios.service.impl.UsuarioServiceImpl;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IReservasMapper {
  IReservasMapper INSTANCE = Mappers.getMapper(IReservasMapper.class);
  final IUsuarioService usuarioService = new UsuarioServiceImpl();
  final IServiciosService serviciosService = new ServiciosServiceImpl();

  // listar todos
  List<ReservasFindAll> toListAll(List<Reservas> reservas);

  @Mapping(target = "usuarioNombre", source = "usuario.nombre")
  @Mapping(target = "servicioNombre", source = "servicio.nombre")
  ReservasFindAll toAll(Reservas reservas);

  // por id
  @Mapping(target = "usuarioNombre", source = "usuario.nombre")
  @Mapping(target = "servicioNombre", source = "servicio.nombre")
  ReservasFindId toId(Reservas reserva);

  // a ENUM
  EstadoReserva toEnum(String estado);

  // de ReservasSave a Reservas
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "usuario.nombre", source = "usuarioNombre")
  @Mapping(target = "servicio.nombre", source = "servicioNombre")
  Reservas toEnt(ReservasSave reservasSave);

  @Named("findUsByNombre")
  default Usuarios findUsuarioByNombre(String nombre) {
    // Lógica para recuperar la entidad Usuarios por el nombre
    return usuarioService.findByNombre(nombre);
  }

  @Named("findSerByNombre")
  default Servicios findServicioByNombre(String nombre) {
    // Lógica para recuperar la entidad Servicios por el nombre
    return serviciosService.findByNombre(nombre);
  }
}
