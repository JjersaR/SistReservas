package com.sist.reserva.usuarios.dto;

import com.sist.reserva.reservas.entity.Reservas;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class UsuarioById implements Serializable {

  private LocalDate fechaRegistro;

  private String nombre;

  private String apellidoPaterno;

  private String apellidoMaterno;

  private String correo;

  private String telefono;

  // ligar con reservas
  private List<Reservas> reservas;

  public LocalDate getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(LocalDate fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public List<Reservas> getReservas() {
    return reservas;
  }

  public void setReservas(List<Reservas> reservas) {
    this.reservas = reservas;
  }
}
