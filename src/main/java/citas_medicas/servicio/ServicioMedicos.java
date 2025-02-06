package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.MedicoDTO;
import citas_medicas.mapper.CitaMapper;
import citas_medicas.mapper.MedicoMapper;
import citas_medicas.repositorio.RepositorioCitas;
import citas_medicas.repositorio.RepositorioMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioMedicos implements IServicioMedicos {

    @Autowired
    private RepositorioMedicos repositorioMedicos;

    @Autowired
    private RepositorioCitas repositorioCitas;

    @Autowired
    private MedicoMapper medicoMapper;

    @Autowired
    private CitaMapper citaMapper;

    public ServicioMedicos(RepositorioMedicos repositorioMedicos, RepositorioCitas repositorioCitas, MedicoMapper medicoMapper, CitaMapper citaMapper) {
        this.repositorioMedicos = repositorioMedicos;
        this.repositorioCitas = repositorioCitas;
        this.medicoMapper = medicoMapper;
        this.citaMapper = citaMapper;
    }

    @Override
    public MedicoDTO registrarMedico(MedicoDTO medicoDTO) {
        Medico medico = medicoMapper.medicoDTOToMedico(medicoDTO);
        medico = repositorioMedicos.save(medico);
        return medicoMapper.medicoToMedicoDTO(medico);
    }

    @Override
    public List<CitaDTO> obtenerCitasMedico(String medicoId) {
        List<Cita> citas = repositorioCitas.findByMedicoId(medicoId);
        return citas.stream().map(citaMapper::citaToCitaDTO).collect(Collectors.toList());
    }
}