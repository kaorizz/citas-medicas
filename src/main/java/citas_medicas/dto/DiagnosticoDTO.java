package citas_medicas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoDTO {

    private String id;
    private String valoracionEspecialista;
    private String enfermedad;
    private CitaDTO cita;
}
