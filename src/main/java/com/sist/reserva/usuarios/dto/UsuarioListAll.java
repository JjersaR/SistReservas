package com.sist.reserva.usuarios.dto;

import com.sist.reserva.reservas.entity.Reservas;
import java.io.Serializable;
import java.util.List;

public class UsuarioListAll implements Serializable {

  // obtener id
  Long id;

  // obtener nombre
  String nombre;

  // obtener el apellidoPaterno
  String apellidoPaterno;

  // obtener el telefono
  String telefono;

  // obtener reservas
  List<Reservas> reservas;

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

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
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
