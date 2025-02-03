package citas_medicas.repositorio;

import citas_medicas.dominio.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, String> {
    List<Cita> findByPacienteId(String pacienteId);

    List<Cita> findByMedicoId(String medicoId);
}