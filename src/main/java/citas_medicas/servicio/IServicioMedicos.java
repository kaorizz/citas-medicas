package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.MedicoDTO;

import java.util.List;

public interface IServicioMedicos {

    MedicoDTO registrarMedico(MedicoDTO medicoDTO);

    List<CitaDTO> obtenerCitasMedico(String medicoId);
}
