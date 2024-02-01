package com.sist.reserva.usuarios.mapper;

import com.sist.reserva.usuarios.dto.UsuarioById;
import com.sist.reserva.usuarios.dto.UsuarioListAll;
import com.sist.reserva.usuarios.dto.UsuarioSave;
import com.sist.reserva.usuarios.entity.Usuarios;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUsuarioMapper {

  IUsuarioMapper INSTANCE = Mappers.getMapper(IUsuarioMapper.class);

  // listar todos
  List<UsuarioListAll> toAllUsuariosListDTO(List<Usuarios> usuarios);

  // Obtener un Usuario por ID
  UsuarioById toUsuarioIdDTO(Usuarios usario);

  // guardar
  @Mapping(target = "reservas", ignore = true)
  Usuarios toUsuarioSave(UsuarioSave usuarioSave);
}
