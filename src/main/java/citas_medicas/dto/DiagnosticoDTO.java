package citas_medicas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoDTO {

    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;
    @JsonIgnore  // 🚨 Evita la recursión infinita
    private CitaDTO cita;
}