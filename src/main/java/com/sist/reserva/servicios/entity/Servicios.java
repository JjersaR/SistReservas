package com.sist.reserva.servicios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.Duration;

@Entity
public class Servicios {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 20)
  private String nombre;

  @Column(nullable = false)
  private BigDecimal precio;

  @Column(nullable = true, length = 20)
  private String categoria;

  @Column(nullable = false)
  private Duration duracion;

  @Column(nullable = false, length = 20)
  @Enumerated(EnumType.STRING)
  private DisponibilidadServicio disponible;

  @Column(length = 50, nullable = true)
  private String ubicacion;

  @Column(nullable = true, columnDefinition = "TEXT")
  private String descripcion;

  /********* GETTER Y SETTER *********/

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

  public DisponibilidadServicio isDisponible() {
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

  /********* HASHCODE Y EQUALS *********/

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((precio == null) ? 0 : precio.hashCode());
    result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
    result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
    result = prime * result + ((disponible == null) ? 0 : disponible.hashCode());
    result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
    result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
    Servicios other = (Servicios) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (precio == null) {
      if (other.precio != null)
        return false;
    } else if (!precio.equals(other.precio))
      return false;
    if (categoria == null) {
      if (other.categoria != null)
        return false;
    } else if (!categoria.equals(other.categoria))
      return false;
    if (duracion == null) {
      if (other.duracion != null)
        return false;
    } else if (!duracion.equals(other.duracion))
      return false;
    if (disponible != other.disponible)
      return false;
    if (ubicacion == null) {
      if (other.ubicacion != null)
        return false;
    } else if (!ubicacion.equals(other.ubicacion))
      return false;
    if (descripcion == null) {
      if (other.descripcion != null)
        return false;
    } else if (!descripcion.equals(other.descripcion))
      return false;
    return true;
  }
}
