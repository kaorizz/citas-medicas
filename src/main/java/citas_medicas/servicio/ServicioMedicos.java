package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.repositorio.RepositorioCitas;
import citas_medicas.repositorio.RepositorioMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMedicos implements IServicioMedicos {

    @Autowired
    private RepositorioMedicos repositorioMedicos;

    @Autowired
    private RepositorioCitas repositorioCitas;

    public ServicioMedicos(RepositorioMedicos repositorioMedicos, RepositorioCitas repositorioCitas) {
        this.repositorioMedicos = repositorioMedicos;
        this.repositorioCitas = repositorioCitas;
    }

    @Override
    public Medico registrarMedico(Medico medico) {
        return repositorioMedicos.save(medico);
    }

    @Override
    public List<Cita> obtenerCitasMedico(String medicoId) {
        return repositorioCitas.findByMedicoId(medicoId);
    }
}