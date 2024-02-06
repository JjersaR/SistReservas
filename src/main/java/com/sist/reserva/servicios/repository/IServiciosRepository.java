package com.sist.reserva.servicios.repository;

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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IServiciosRepository extends JpaRepository<Servicios, Long> {

  // Obtener un Servicio por ID
  Optional<Servicios> findById(Long id);

  // Obtener Servicios por Categoría
  List<IServiciosPorCategoria> findByCategoria(String categoria);

  // Obtener Servicios Disponibles
  List<IServiciosDisponibles> findByDisponible(DisponibilidadServicio disponible);

  // Obtener Servicios por Ubicación
  List<IServiciosPorUbicacion> findByUbicacion(String ubicacion);

  // Obtener Servicios con Duración Específica
  List<IServiciosPorDuracion> findByDuracion(Duration duracion);

  // Obtener Servicios con Precio Menor a un Valor
  List<IServiciosConPreciosMenores> findByPrecioLessThan(BigDecimal precio);

  // obtener por nombre
  Servicios findByNombre(String nombre);

  // actualizar
  @Query("UPDATE Servicios s SET s.nombre = :#{#servicio.nombre}, s.precio = :#{#servicio.precio},"
      + " s.categoria = :#{#servicio.categoria}, s.duracion = :#{#servicio.duracion},"
      + " s.disponible = :#{#servicio.disponible}, s.ubicacion = :#{#servicio.ubicacion},"
      + " s.descripcion = :#{#servicio.descripcion} WHERE s.id = :#{#servicio.id}")
  @Modifying
  @Transactional
  void update(ServiciosUpdate servicio);
}
