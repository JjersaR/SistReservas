package com.sist.reserva.usuarios.service.impl;

import com.sist.reserva.controller.handleEx.ObjetoNoContentException;
import com.sist.reserva.controller.handleEx.ObjetoNotFoundException;
import com.sist.reserva.usuarios.dao.IUsuariosDAO;
import com.sist.reserva.usuarios.dto.ReservasDeUsuarioList;
import com.sist.reserva.usuarios.dto.ReservasPendientesList;
import com.sist.reserva.usuarios.dto.ServiciosReservadosPorUsuarioList;
import com.sist.reserva.usuarios.dto.UsuarioUpdate;
import com.sist.reserva.usuarios.dto.UsuariosPorRangoFechasList;
import com.sist.reserva.usuarios.entity.Usuarios;
import com.sist.reserva.usuarios.service.IUsuarioService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
  @Autowired
  private IUsuariosDAO usuarioDAO;

  @Override
  public List<Usuarios> findAll() {
    if (usuarioDAO.findAll().isEmpty())
      throw new ObjetoNoContentException("Lista de Usuarios Vacia");
    return usuarioDAO.findAll();
  }

  @Override
  public Optional<Usuarios> findById(Long id) {
    if (usuarioDAO.findById(id).isEmpty())
      throw new ObjetoNotFoundException("Este usuario no existe");
    return usuarioDAO.findById(id);
  }

  @Override
  public List<ReservasDeUsuarioList> findReservasByUsuarioId(Long usuarioId) {
    if (usuarioDAO.findReservasByUsuarioId(usuarioId).isEmpty())
      throw new ObjetoNoContentException("Lista de Reservas del Usuario " + usuarioId + " vacia");
    return usuarioDAO.findReservasByUsuarioId(usuarioId);
  }

  @Override
  public List<ServiciosReservadosPorUsuarioList> findServiciosReservadosByUsuarioId(
      Long usuarioId) {
    if (usuarioDAO.findServiciosReservadosByUsuarioId(usuarioId).isEmpty())
      throw new ObjetoNoContentException("Lista de Servicios reservados por el usuario " + usuarioId + " vacia");
    return usuarioDAO.findServiciosReservadosByUsuarioId(usuarioId);
  }

  @Override
  public List<ReservasPendientesList> findUsuariosConReservasPendientes() {
    if (usuarioDAO.findUsuariosConReservasPendientes().isEmpty())
      throw new ObjetoNoContentException("Lista de Usuarios con Reservas Pendientes VACIA");
    return usuarioDAO.findUsuariosConReservasPendientes();
  }

  @Override
  public List<UsuariosPorRangoFechasList> findUsuariosByFechaRegistroBetween(
      LocalDate fechaInicio, LocalDate fechaFin) {
    if (usuarioDAO.findUsuariosByFechaRegistroBetween(fechaInicio, fechaFin).isEmpty())
      throw new ObjetoNoContentException("No hay usuarios registrados en las fechas ingresadas");
    return usuarioDAO.findUsuariosByFechaRegistroBetween(fechaInicio, fechaFin);
  }

  @Override
  public void save(Usuarios usuario) {
    usuarioDAO.save(usuario);
  }

  @Override
  public void update(UsuarioUpdate usuario) {
    usuarioDAO.update(usuario);
  }

  @Override
  public void deleteById(Long id) {
    usuarioDAO.deleteById(id);
  }

  @Override
  public Usuarios findByNombre(String nombre) {
    return usuarioDAO.findByNombre(nombre);
  }
}
