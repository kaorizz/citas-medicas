package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Paciente;

import java.util.List;

public interface IServicioPacientes {
    Paciente registrarPaciente(Paciente paciente);
    List<Cita> obtenerCitasPaciente(String pacienteId);
}
