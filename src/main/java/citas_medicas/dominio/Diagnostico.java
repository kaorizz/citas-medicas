package citas_medicas.dominio;

import citas_medicas.dto.DiagnosticoDTO;
import jakarta.persistence.*;
import lombok.*;
import utils.Utils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;

    @OneToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;

    // Metodo para convertir un Diagnostico en un DiagnosticoDTO
    public DiagnosticoDTO toDTO() {
        return new DiagnosticoDTO(this.id, this.valoracionEspecialista, this.enfermedad, this.cita.toDTO());
    }
}
