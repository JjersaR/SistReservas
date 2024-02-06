package com.sist.reserva.reservas.dto;

import java.time.LocalDate;

public interface ReservasByServicio {

  String getUsuarioNombre();

  int getNumPersonas();

  String getServicioNombre();

  LocalDate getFechaInicio();

  LocalDate getFechaFin();

  String getEstado();
}
