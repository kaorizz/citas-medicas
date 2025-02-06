package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Paciente;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.PacienteDTO;

import java.util.List;

public interface IServicioPacientes {

    PacienteDTO registrarPaciente(PacienteDTO paciente);

    List<CitaDTO> obtenerCitasPaciente(String pacienteId);
}
