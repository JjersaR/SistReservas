package com.sist.reserva.servicios.dto;

import java.math.BigDecimal;
import java.time.Duration;

public interface IServiciosPorUbicacion {

  String getNombre();

  BigDecimal getPrecio();

  String getCategoria();

  Duration getDuracion();

  String getDisponible();

  String getUbicacion();

  String getDescripcion();
}
