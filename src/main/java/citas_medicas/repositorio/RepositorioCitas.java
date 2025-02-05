package citas_medicas.repositorio;

import citas_medicas.dominio.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositorioCitas extends JpaRepository<Cita, String> {

    @Query("SELECT c FROM Cita c WHERE c.paciente.id = :pacienteId")
    List<Cita> findByPacienteId(String pacienteId);

    @Query("SELECT c FROM Cita c WHERE c.medico.id = :medicoId")
    List<Cita> findByMedicoId(String medicoId);

    @Query("SELECT COUNT(c) > 0 FROM Cita c WHERE c.paciente.id = :pacienteId AND c.fechaHora BETWEEN :inicio AND :fin")
    boolean existsByPacienteIdAndFechaHora(String pacienteId, LocalDateTime inicio, LocalDateTime fin);

    @Query("SELECT COUNT(c) > 0 FROM Cita c WHERE c.medico.id = :medicoId AND c.fechaHora BETWEEN :inicio AND :fin")
    boolean existsByMedicoIdAndFechaHora(String medicoId, LocalDateTime inicio, LocalDateTime fin);
}