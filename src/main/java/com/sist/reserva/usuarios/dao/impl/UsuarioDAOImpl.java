package com.sist.reserva.usuarios.dao.impl;

import com.sist.reserva.usuarios.dao.IUsuariosDAO;
import com.sist.reserva.usuarios.dto.ReservasDeUsuarioList;
import com.sist.reserva.usuarios.dto.ReservasPendientesList;
import com.sist.reserva.usuarios.dto.ServiciosReservadosPorUsuarioList;
import com.sist.reserva.usuarios.dto.UsuarioUpdate;
import com.sist.reserva.usuarios.dto.UsuariosPorRangoFechasList;
import com.sist.reserva.usuarios.entity.Usuarios;
import com.sist.reserva.usuarios.repository.IUsuarioRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDAOImpl implements IUsuariosDAO {

  @Autowired
  private IUsuarioRepository usuarioRepository;

  @Override
  public List<Usuarios> findAll() {
    return usuarioRepository.findAll();
  }

  @Override
  public Optional<Usuarios> findById(Long id) {
    return usuarioRepository.findById(id);
  }

  @Override
  public List<ReservasDeUsuarioList> findReservasByUsuarioId(Long usuarioId) {
    return usuarioRepository.reservasUsuarioById(usuarioId);
  }

  @Override
  public List<ServiciosReservadosPorUsuarioList> findServiciosReservadosByUsuarioId(
      Long usuarioId) {
    return usuarioRepository.findServiciosReservadosById(usuarioId);
  }

  @Override
  public List<ReservasPendientesList> findUsuariosConReservasPendientes() {
    return usuarioRepository.findByReservasPendientes();
  }

  @Override
  public List<UsuariosPorRangoFechasList> findUsuariosByFechaRegistroBetween(
      LocalDate fechaInicio, LocalDate fechaFin) {
    return usuarioRepository.findUsuariosByFechaRegistroBetween(fechaInicio, fechaFin);
  }

  @Override
  public void save(Usuarios usuario) {
    usuarioRepository.save(usuario);
  }

  @Override
  public void update(UsuarioUpdate usuario) {
    usuarioRepository.update(usuario);
  }

  @Override
  public void deleteById(Long id) {
    usuarioRepository.deleteById(id);
  }
}
