package com.sist.reserva.servicios.dto;

import java.math.BigDecimal;

public interface IServiciosPorDuracion {
  String getNombre();

  BigDecimal getPrecio();

  String getCategoria();

  int getDuracion();

  String getDisponible();

  String getUbicacion();

  String getDescripcion();
}
