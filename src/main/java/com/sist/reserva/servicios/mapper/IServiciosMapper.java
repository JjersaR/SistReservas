package com.sist.reserva.servicios.mapper;

import com.sist.reserva.servicios.dto.ServiciosAllList;
import com.sist.reserva.servicios.dto.ServiciosUpdate;
import com.sist.reserva.servicios.entity.DisponibilidadServicio;
import com.sist.reserva.servicios.entity.Servicios;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IServiciosMapper {

  IServiciosMapper INSTANCE = Mappers.getMapper(IServiciosMapper.class);

  // listar todos
  List<ServiciosAllList> toAllListDTO(List<Servicios> servicios);

  // para que no dé error
  // @Mapping(target = "disponible", source = "disponible")
  ServiciosAllList map(Servicios value);

  DisponibilidadServicio mapToEnum(String disponibilidad);

  // de ServiciosUpdate a Servicios
  Servicios toEnt(ServiciosUpdate serviciosUpdate);
}
