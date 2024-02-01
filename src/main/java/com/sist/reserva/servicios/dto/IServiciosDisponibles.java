package com.sist.reserva.servicios.dto;

import java.math.BigDecimal;

public interface IServiciosDisponibles {

  String getNombre();

  BigDecimal getPrecio();

  int getDuracion();

  String getDisponible();

  String getUbicacion();

  String getDescripcion();
}
