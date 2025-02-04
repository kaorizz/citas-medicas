package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Diagnostico;
import citas_medicas.repositorio.RepositorioCitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDiagnosticos implements IServicioDiagnosticos {

    @Autowired
    private RepositorioCitas repositorioCitas;

    public
    ServicioDiagnosticos(RepositorioCitas repositorioCitas) {
        this.repositorioCitas = repositorioCitas;
    }

    @Override
    public Cita realizarDiagnostico(String citaId, Diagnostico diagnostico) {
        Cita cita = repositorioCitas.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        cita.setDiagnostico(diagnostico);
        return repositorioCitas.save(cita);
    }
}
