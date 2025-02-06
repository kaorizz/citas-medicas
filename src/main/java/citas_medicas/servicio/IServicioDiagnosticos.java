package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Diagnostico;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.DiagnosticoDTO;

public interface IServicioDiagnosticos {

    CitaDTO realizarDiagnostico(String citaId, DiagnosticoDTO diagnosticoDTO);
}
