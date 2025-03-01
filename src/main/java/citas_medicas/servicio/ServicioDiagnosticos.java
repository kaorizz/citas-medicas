package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Diagnostico;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.DiagnosticoDTO;
import citas_medicas.mapper.CitaMapper;
import citas_medicas.mapper.DiagnosticoMapper;
import citas_medicas.repositorio.RepositorioCitas;
import citas_medicas.repositorio.RepositorioDiagnosticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDiagnosticos implements IServicioDiagnosticos {

    @Autowired
    private RepositorioCitas repositorioCitas;

    @Autowired
    private RepositorioDiagnosticos repositorioDiagnosticos;

    @Autowired
    private DiagnosticoMapper diagnosticoMapper;

    @Autowired
    private CitaMapper citaMapper;

    public
    ServicioDiagnosticos(RepositorioCitas repositorioCitas) {}

    @Override
    public CitaDTO realizarDiagnostico(String citaId, DiagnosticoDTO diagnosticoDTO) {
        Cita cita = repositorioCitas.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        Diagnostico diagnostico = diagnosticoMapper.diagnosticoDTOToDiagnostico(diagnosticoDTO);
        diagnostico.setCita(cita);
        diagnostico = repositorioDiagnosticos.save(diagnostico);
        cita.setDiagnostico(diagnostico);
        Cita citaActualizada = repositorioCitas.save(cita);
        return citaMapper.citaToCitaDTO(citaActualizada);
    }
}
