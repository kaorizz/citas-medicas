package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Paciente;
import citas_medicas.repositorio.CitaRepositorio;
import citas_medicas.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPacientes implements IServicioPacientes {
    @Autowired
    private PacienteRepositorio pacienteRepositorio;
    @Autowired
    private CitaRepositorio citaRepositorio;

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepositorio.save(paciente);
    }

    @Override
    public List<Cita> obtenerCitasPaciente(String pacienteId) {
        return citaRepositorio.findByPacienteId(pacienteId);
    }
}
