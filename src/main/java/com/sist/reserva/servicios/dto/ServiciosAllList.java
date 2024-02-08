package com.sist.reserva.servicios.dto;

import com.sist.reserva.servicios.entity.DisponibilidadServicio;

import java.math.BigDecimal;
import java.time.Duration;

public class ServiciosAllList {

  private Long id;

  private String nombre;

  private BigDecimal precio;

  private String categoria;

  private Duration duracion;

  private DisponibilidadServicio disponible;

  private String ubicacion;

  private String descripcion;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public Duration getDuracion() {
    return duracion;
  }

  public void setDuracion(Duration duracion) {
    this.duracion = duracion;
  }

  public DisponibilidadServicio getDisponible() {
    return disponible;
  }

  public void setDisponible(DisponibilidadServicio disponible) {
    this.disponible = disponible;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
