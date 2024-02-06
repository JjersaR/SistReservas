package com.sist.reserva.servicios.service;

import com.sist.reserva.servicios.dto.IServiciosConPreciosMenores;
import com.sist.reserva.servicios.dto.IServiciosDisponibles;
import com.sist.reserva.servicios.dto.IServiciosPorCategoria;
import com.sist.reserva.servicios.dto.IServiciosPorDuracion;
import com.sist.reserva.servicios.dto.IServiciosPorUbicacion;
import com.sist.reserva.servicios.dto.ServiciosUpdate;
import com.sist.reserva.servicios.entity.DisponibilidadServicio;
import com.sist.reserva.servicios.entity.Servicios;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public interface IServiciosService {

  // listar todos
  List<Servicios> findAll();

  // Obtener un Servicio por ID
  Optional<Servicios> findById(Long id);

  // Obtener Servicios por Categoría
  List<IServiciosPorCategoria> findByCategoria(String categoria);

  // Obtener Servicios Disponibles
  List<IServiciosDisponibles> findServiciosByDisponible(DisponibilidadServicio disponible);

  // Obtener Servicios por Ubicación
  List<IServiciosPorUbicacion> findServiciosByUbicacion(String ubicacion);

  // Obtener Servicios con Duración Específica
  List<IServiciosPorDuracion> findServiciosByDuracion(Duration duracion);

  // Obtener Servicios con Precio Menor a un Valor
  List<IServiciosConPreciosMenores> findServiciosByPrecioLessThan(BigDecimal precio);

  // obtener por nombre
  Servicios findByNombre(String nombre);

  // guardar
  void save(Servicios servicio);

  // actualizar
  void update(ServiciosUpdate servicio);

  // eliminar
  void deleteById(Long id);
}
