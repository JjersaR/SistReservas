package com.sist.reserva.usuarios.dto;

import java.math.BigDecimal;
import java.time.Duration;

public interface ServiciosReservadosPorUsuarioList {

  String getUsuarioNombre();

  String getNombre();

  BigDecimal getPrecio();

  String getCategoria();

  Duration getDuracion();

  String getUbicacion();

  String getReservaEstado();
}
