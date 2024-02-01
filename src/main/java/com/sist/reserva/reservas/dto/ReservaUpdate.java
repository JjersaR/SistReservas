package com.sist.reserva.reservas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

public class ReservaUpdate {
  @JsonIgnore
  private Long id;

  private Long usuarioId;

  private int numPersonas;

  private Long servicioId;

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

  public Long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(Long usuarioId) {
    this.usuarioId = usuarioId;
  }

  public int getNumPersonas() {
    return numPersonas;
  }

  public void setNumPersonas(int numPersonas) {
    this.numPersonas = numPersonas;
  }

  public Long getServicioId() {
    return servicioId;
  }

  public void setServicioId(Long servicioId) {
    this.servicioId = servicioId;
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
