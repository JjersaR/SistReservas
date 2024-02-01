package com.sist.reserva.servicios.repository;

import com.sist.reserva.servicios.dto.ServiciosUpdate;
import com.sist.reserva.servicios.entity.DisponibilidadServicio;
import com.sist.reserva.servicios.entity.Servicios;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiciosRepository extends JpaRepository<Servicios, Long> {

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

  // actualizar
  @Query("UPDATE Servicios s SET s.nombre = :#{#servicio.nombre}, s.precio = :#{#servicio.precio},"
      + " s.categoria = :#{#servicio.categoria}, s.duracion = :#{#servicio.duracion},"
      + " s.disponible = :#{#servicio.disponible}, s.ubicacion = :#{#servicio.ubicacion},"
      + " s.descripcion = :#{#servicio.descripcion} WHERE s.id = :#{#servicio.id}")
  void update(ServiciosUpdate servicio);
}
