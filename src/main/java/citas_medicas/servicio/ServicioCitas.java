package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.dominio.Paciente;
import citas_medicas.dto.CitaDTO;
import citas_medicas.mapper.CitaMapper;
import citas_medicas.repositorio.RepositorioCitas;
import citas_medicas.repositorio.RepositorioMedicos;
import citas_medicas.repositorio.RepositorioPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicioCitas implements IServicioCitas {

    @Autowired
    private RepositorioCitas repositorioCitas;

    @Autowired
    private RepositorioPacientes repositorioPacientes;

    @Autowired
    private RepositorioMedicos repositorioMedicos;

    @Autowired
    private CitaMapper citaMapper;

    public ServicioCitas(RepositorioCitas repositorioCitas, RepositorioPacientes repositorioPacientes, RepositorioMedicos repositorioMedicos, CitaMapper citaMapper) {
        this.repositorioCitas = repositorioCitas;
        this.repositorioPacientes = repositorioPacientes;
        this.repositorioMedicos = repositorioMedicos;
        this.citaMapper = citaMapper;
    }

    @Override
    public CitaDTO agendarCita(String pacienteId, String medicoId, LocalDateTime fechaHora) {
        Paciente paciente = repositorioPacientes.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = repositorioMedicos.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        LocalDateTime inicio = fechaHora.minusMinutes(15);
        LocalDateTime fin = fechaHora.plusMinutes(15);

        boolean existeCita = repositorioCitas.existsByPacienteIdAndFechaHora(pacienteId, inicio, fin) ||
                repositorioCitas.existsByMedicoIdAndFechaHora(medicoId, inicio, fin);

        if (existeCita) {
            throw new RuntimeException("No se puede agendar la cita, ya existe una cita en un intervalo de 15 minutos.");
        }

        Cita nuevaCita = new Cita();
        nuevaCita.setPaciente(paciente);
        nuevaCita.setMedico(medico);
        nuevaCita.setFechaHora(fechaHora);

        Cita citaGuardada = repositorioCitas.save(nuevaCita);

        return citaMapper.citaToCitaDTO(citaGuardada);
    }

    @Override
    public void cancelarCita(String citaId) {
        Cita cita = repositorioCitas.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        repositorioCitas.delete(cita);
    }
}
