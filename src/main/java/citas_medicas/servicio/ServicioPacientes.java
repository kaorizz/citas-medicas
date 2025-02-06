package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.dominio.Paciente;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.PacienteDTO;
import citas_medicas.mapper.CitaMapper;
import citas_medicas.mapper.PacienteMapper;
import citas_medicas.repositorio.RepositorioCitas;
import citas_medicas.repositorio.RepositorioPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioPacientes implements IServicioPacientes {

    @Autowired
    private RepositorioPacientes repositorioPacientes;

    @Autowired
    private RepositorioCitas repositorioCitas;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private CitaMapper citaMapper;

    public ServicioPacientes(RepositorioPacientes repositorioPacientes, RepositorioCitas repositorioCitas, PacienteMapper pacienteMapper, CitaMapper citaMapper) {
        this.repositorioPacientes = repositorioPacientes;
        this.repositorioCitas = repositorioCitas;
        this.pacienteMapper = pacienteMapper;
        this.citaMapper = citaMapper;
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteMapper.pacienteDTOToPaciente(pacienteDTO);
        paciente = repositorioPacientes.save(paciente);
        return pacienteMapper.pacienteToPacienteDTO(paciente);
    }

    @Override
    public List<CitaDTO> obtenerCitasPaciente(String pacienteId) {
        List<Cita> citas = repositorioCitas.findByPacienteId(pacienteId);
        return citas.stream().map(citaMapper::citaToCitaDTO).collect(Collectors.toList());
    }
}
