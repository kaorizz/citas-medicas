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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mi_seq_generator")
    @SequenceGenerator(name = "mi_seq_generator", sequenceName = "MI_SEQ", allocationSize = 1)
    private Long id;
    private String valoracionEspecialista;
    private String enfermedad;

    @OneToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;
}
