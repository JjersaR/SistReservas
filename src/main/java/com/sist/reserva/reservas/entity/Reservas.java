package com.sist.reserva.reservas.entity;

import com.sist.reserva.servicios.entity.Servicios;
import com.sist.reserva.usuarios.entity.Usuarios;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reservas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = Usuarios.class)
  @JoinColumn(name = "usuario_id")
  private Usuarios usuario;

  @Column(name = "numero_personas", nullable = true)
  private int numPersonas;

  @ManyToOne(targetEntity = Servicios.class)
  @JoinColumn(name = "servio_id")
  private Servicios servicio;

  @Column(name = "fecha_inicio", columnDefinition = "DATE", nullable = false)
  private LocalDate fechaInicio;

  @Column(name = "fecha_fin", columnDefinition = "DATE", nullable = false)
  private LocalDate fechaFin;

  @Column(length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private EstadoReserva estado;

  @Column(columnDefinition = "TEXT", nullable = true)
  private String notas;

  /*********** GETTER Y SETTER ************/

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Usuarios getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuarios usuario) {
    this.usuario = usuario;
  }

  public int getNumPersonas() {
    return numPersonas;
  }

  public void setNumPersonas(int numPersonas) {
    this.numPersonas = numPersonas;
  }

  public Servicios getServicio() {
    return servicio;
  }

  public void setServicio(Servicios servicio) {
    this.servicio = servicio;
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

  /*********** HASHCODE Y EQUALS ************/

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
    result = prime * result + numPersonas;
    result = prime * result + ((servicio == null) ? 0 : servicio.hashCode());
    result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
    result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
    result = prime * result + ((estado == null) ? 0 : estado.hashCode());
    result = prime * result + ((notas == null) ? 0 : notas.hashCode());
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
    Reservas other = (Reservas) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (usuario == null) {
      if (other.usuario != null)
        return false;
    } else if (!usuario.equals(other.usuario))
      return false;
    if (numPersonas != other.numPersonas)
      return false;
    if (servicio == null) {
      if (other.servicio != null)
        return false;
    } else if (!servicio.equals(other.servicio))
      return false;
    if (fechaInicio == null) {
      if (other.fechaInicio != null)
        return false;
    } else if (!fechaInicio.equals(other.fechaInicio))
      return false;
    if (fechaFin == null) {
      if (other.fechaFin != null)
        return false;
    } else if (!fechaFin.equals(other.fechaFin))
      return false;
    if (estado == null) {
      if (other.estado != null)
        return false;
    } else if (!estado.equals(other.estado))
      return false;
    if (notas == null) {
      if (other.notas != null)
        return false;
    } else if (!notas.equals(other.notas))
      return false;
    return true;
  }
}
