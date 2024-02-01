package com.sist.reserva.usuarios.dto;

import java.time.LocalDate;

public interface ReservasDeUsuarioList {

  Long getId();

  String getUsuarioNombre();

  int getNumPersonas();

  String getServicioNombre();

  LocalDate getFechaInicio();

  LocalDate getFechaFin();

  String getEstado();
}
