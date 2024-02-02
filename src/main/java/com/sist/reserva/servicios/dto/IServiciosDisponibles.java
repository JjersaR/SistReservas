package com.sist.reserva.servicios.dto;

import java.math.BigDecimal;
import java.time.Duration;

public interface IServiciosDisponibles {

  String getNombre();

  BigDecimal getPrecio();

  Duration getDuracion();

  String getDisponible();

  String getUbicacion();

  String getDescripcion();
}
