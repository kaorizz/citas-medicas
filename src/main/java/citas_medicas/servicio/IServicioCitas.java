package citas_medicas.servicio;

import citas_medicas.dominio.Cita;

import java.time.LocalDateTime;

public interface IServicioCitas {

    Cita agendarCita(String pacienteId, String medicoId, LocalDateTime fechaHora);

    void cancelarCita(String citaId);
}
