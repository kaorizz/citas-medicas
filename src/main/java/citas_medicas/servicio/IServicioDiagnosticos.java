package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Diagnostico;

public interface IServicioDiagnosticos {

    Cita realizarDiagnostico(String citaId, Diagnostico diagnostico);
}
