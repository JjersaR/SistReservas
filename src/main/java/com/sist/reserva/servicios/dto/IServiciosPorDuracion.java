package com.sist.reserva.servicios.dto;

import java.math.BigDecimal;
import java.time.Duration;

public interface IServiciosPorDuracion {
  String getNombre();

  BigDecimal getPrecio();

  String getCategoria();

  Duration getDuracion();

  String getDisponible();

  String getUbicacion();

  String getDescripcion();
}
