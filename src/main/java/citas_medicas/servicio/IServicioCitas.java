package citas_medicas.servicio;

import citas_medicas.dominio.Cita;
import citas_medicas.dto.CitaDTO;

import java.time.LocalDateTime;

public interface IServicioCitas {

    CitaDTO agendarCita(String pacienteId, String medicoId, LocalDateTime fechaHora);

    void cancelarCita(String citaId);
}
