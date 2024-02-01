package com.sist.reserva.servicios.dto;

import java.math.BigDecimal;

public interface IServiciosPorCategoria {

  String getNombre();

  BigDecimal getPrecio();

  String getCategoria();

  int getDuracion();

  String getDisponible();

  String getUbicacion();

  String getDescripcion();
}
