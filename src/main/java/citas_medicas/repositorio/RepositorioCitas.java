package citas_medicas.repositorio;

import citas_medicas.dominio.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositorioCitas extends JpaRepository<Cita, String> {

    List<Cita> findByPacienteId(String pacienteId);

    List<Cita> findByMedicoId(String medicoId);

    boolean existsByPacienteIdAndFechaHora(String pacienteId, LocalDateTime inicio, LocalDateTime fin);

    boolean existsByMedicoIdAndFechaHora(String medicoId, LocalDateTime inicio, LocalDateTime fin);
}