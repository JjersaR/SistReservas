package com.sist.reserva.reservas.dto;

import java.time.LocalDate;

public interface ReservasByUsuario {

  String getUsuarioNombre();

  int getNumPersonas();

  String getServicioNombre();

  LocalDate getFechaInicio();

  LocalDate getFechaFin();

  String getEstado();

  String getNotas();
}
