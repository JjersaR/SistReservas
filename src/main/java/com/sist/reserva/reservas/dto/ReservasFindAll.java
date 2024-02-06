package com.sist.reserva.reservas.dto;

import java.time.LocalDate;

public class ReservasFindAll {

  private Long id;

  private String usuarioNombre;

  private int numPersonas;

  private String servicioNombre;

  private LocalDate fechaInicio;

  private LocalDate fechaFin;

  private String estado;

  private String notas;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
