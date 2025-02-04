package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Paciente;
import citas_medicas.repositorio.RepositorioCitas;
import citas_medicas.repositorio.RepositorioPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPacientes implements IServicioPacientes {

    @Autowired
    private RepositorioPacientes repositorioPacientes;

    @Autowired
    private RepositorioCitas repositorioCitas;

    public ServicioPacientes(RepositorioPacientes repositorioPacientes, RepositorioCitas repositorioCitas) {
        this.repositorioPacientes = repositorioPacientes;
        this.repositorioCitas = repositorioCitas;
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        return repositorioPacientes.save(paciente);
    }

    @Override
    public List<Cita> obtenerCitasPaciente(String pacienteId) {
        return repositorioCitas.findByPacienteId(pacienteId);
    }
}
