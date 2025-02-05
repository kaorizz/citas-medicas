package citas_medicas.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {

    private Long id;
    private LocalDateTime fechaHora;
    private String motivoCita;
    private PacienteDTO paciente;
    private MedicoDTO medico;
    private DiagnosticoDTO diagnostico;
}