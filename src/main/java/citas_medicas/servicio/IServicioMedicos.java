package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;

import java.util.List;

public interface IServicioMedicos {

    Medico registrarMedico(Medico medico);

    List<Cita> obtenerCitasMedico(String medicoId);
}
