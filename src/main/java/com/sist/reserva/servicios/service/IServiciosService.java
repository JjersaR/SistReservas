package com.sist.reserva.servicios.service;

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
  List<Servicios> findByCategoria(String categoria);

  // Obtener Servicios Disponibles
  List<Servicios> findServiciosByDisponible(DisponibilidadServicio disponible);

  // Obtener Servicios por Ubicación
  List<Servicios> findServiciosByUbicacion(String ubicacion);

  // Obtener Servicios con Duración Específica
  List<Servicios> findServiciosByDuracion(Duration duracion);

  // Obtener Servicios con Precio Menor a un Valor
  List<Servicios> findServiciosByPrecioLessThan(BigDecimal precio);

  // guardar
  void save(Servicios servicio);

  // actualizar
  void update(ServiciosUpdate servicio);

  // eliminar
  void deleteById(Long id);
}
