package com.sist.reserva.reservas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sist.reserva.reservas.entity.EstadoReserva;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class ReservaUpdate {
  @JsonIgnore
  private Long id;

  @NotNull
  private Long usuarioId;

  @Nullable
  private int numPersonas;

  @NotNull
  private Long servicioId;

  @PastOrPresent
  private LocalDate fechaInicio;

  @Future
  private LocalDate fechaFin;

  @Nullable
  private EstadoReserva estado;

  @Nullable
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

  public EstadoReserva getEstado() {
    return estado;
  }

  public void setEstado(EstadoReserva estado) {
    this.estado = estado;
  }

  public String getNotas() {
    return notas;
  }

  public void setNotas(String notas) {
    this.notas = notas;
  }
}
