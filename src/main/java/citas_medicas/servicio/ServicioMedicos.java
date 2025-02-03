package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.repositorio.CitaRepositorio;
import citas_medicas.repositorio.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMedicos implements IServicioMedicos {

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Autowired
    private CitaRepositorio citaRepositorio;

    @Override
    public Medico registrarMedico(Medico medico) {
        return medicoRepositorio.save(medico);
    }

    @Override
    public List<Cita> obtenerCitasMedico(String medicoId) {
        return citaRepositorio.findByMedicoId(medicoId);
    }
}