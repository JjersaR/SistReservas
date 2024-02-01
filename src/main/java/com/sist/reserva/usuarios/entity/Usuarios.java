package com.sist.reserva.usuarios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sist.reserva.reservas.entity.Reservas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuarios {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fecha_registro", columnDefinition = "DATE", updatable = false)
  private LocalDate fechaRegistro;

  @Column(length = 45)
  private String nombre;

  @Column(length = 45, name = "apellido_paterno")
  private String apellidoPaterno;

  @Column(length = 45, name = "apellido_materno")
  private String apellidoMaterno;

  @Column(unique = true)
  private String correo;

  @Column(length = 10)
  private String telefono;

  // ligar con reservas
  @OneToMany(targetEntity = Reservas.class, mappedBy = "usuario", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Reservas> reservas;

  /********** GETTER Y SETTER **********/

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  /********** GETTER Y SETTER **********/

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
    result = prime * result + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
    result = prime * result + ((correo == null) ? 0 : correo.hashCode());
    result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Usuarios other = (Usuarios) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (fechaRegistro == null) {
      if (other.fechaRegistro != null)
        return false;
    } else if (!fechaRegistro.equals(other.fechaRegistro))
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (apellidoPaterno == null) {
      if (other.apellidoPaterno != null)
        return false;
    } else if (!apellidoPaterno.equals(other.apellidoPaterno))
      return false;
    if (apellidoMaterno == null) {
      if (other.apellidoMaterno != null)
        return false;
    } else if (!apellidoMaterno.equals(other.apellidoMaterno))
      return false;
    if (correo == null) {
      if (other.correo != null)
        return false;
    } else if (!correo.equals(other.correo))
      return false;
    if (telefono == null) {
      if (other.telefono != null)
        return false;
    } else if (!telefono.equals(other.telefono))
      return false;
    return true;
  }
}
