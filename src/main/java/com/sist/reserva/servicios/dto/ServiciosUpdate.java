package com.sist.reserva.servicios.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sist.reserva.servicios.entity.DisponibilidadServicio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Duration;
import org.springframework.lang.Nullable;

public class ServiciosUpdate {

  @JsonIgnore
  @Nullable
  private Long id;

  @NotBlank
  private String nombre;

  @NotNull
  private BigDecimal precio;

  @Nullable
  private String categoria;

  @NotNull
  private Duration duracion;

  @NotNull
  private DisponibilidadServicio disponible;

  @NotBlank
  private String ubicacion;

  @Nullable
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
