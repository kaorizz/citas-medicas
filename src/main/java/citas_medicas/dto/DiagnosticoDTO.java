package citas_medicas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoDTO {

    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;
    private CitaDTO cita;
}