package com.sist.reserva.usuarios.dto;

import java.time.LocalDate;

public interface UsuariosPorRangoFechasList {

  String getUsuarioNombre();

  LocalDate getFechaRegistro();

  String getCorreo();

  String getTelefono();
}
