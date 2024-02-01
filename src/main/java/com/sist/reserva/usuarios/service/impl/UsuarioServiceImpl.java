package com.sist.reserva.usuarios.service.impl;

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
  private IUsuariosDAO usuariosDAO;

  @Override
  public List<Usuarios> findAll() {
    return usuariosDAO.findAll();
  }

  @Override
  public Optional<Usuarios> findById(Long id) {
    return usuariosDAO.findById(id);
  }

  @Override
  public List<ReservasDeUsuarioList> findReservasByUsuarioId(Long usuarioId) {
    return usuariosDAO.findReservasByUsuarioId(usuarioId);
  }

  @Override
  public List<ServiciosReservadosPorUsuarioList> findServiciosReservadosByUsuarioId(
      Long usuarioId) {
    return usuariosDAO.findServiciosReservadosByUsuarioId(usuarioId);
  }

  @Override
  public List<ReservasPendientesList> findUsuariosConReservasPendientes() {
    return usuariosDAO.findUsuariosConReservasPendientes();
  }

  @Override
  public List<UsuariosPorRangoFechasList> findUsuariosByFechaRegistroBetween(
      LocalDate fechaInicio, LocalDate fechaFin) {
    return usuariosDAO.findUsuariosByFechaRegistroBetween(fechaInicio, fechaFin);
  }

  @Override
  public void save(Usuarios usuario) {
    usuariosDAO.save(usuario);
  }

  @Override
  public void update(UsuarioUpdate usuario) {
    usuariosDAO.update(usuario);
  }

  @Override
  public void deleteById(Long id) {
    usuariosDAO.deleteById(id);
  }
}
