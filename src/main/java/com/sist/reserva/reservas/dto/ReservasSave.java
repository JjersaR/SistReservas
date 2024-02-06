package com.sist.reserva.reservas.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class ReservasSave {

  @NotBlank
  private String usuarioNombre;

  @NotNull
  private int numPersonas;

  @NotBlank
  private String servicioNombre;

  @PastOrPresent
  private LocalDate fechaInicio;

  @Future
  private LocalDate fechaFin;

  @NotBlank
  private String estado;

  @Nullable
  private String notas;

  public String getUsuarioNombre() {
    return usuarioNombre;
  }

  public void setUsuarioNombre(String usuarioNombre) {
    this.usuarioNombre = usuarioNombre;
  }

  public int getNumPersonas() {
    return numPersonas;
  }

  public void setNumPersonas(int numPersonas) {
    this.numPersonas = numPersonas;
  }

  public String getServicioNombre() {
    return servicioNombre;
  }

  public void setServicioNombre(String servicioNombre) {
    this.servicioNombre = servicioNombre;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(LocalDate fechaFin) {
    this.fechaFin = fechaFin;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getNotas() {
    return notas;
  }

  public void setNotas(String notas) {
    this.notas = notas;
  }
}
