package citas_medicas.dominio;

import citas_medicas.dto.CitaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.Utils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mi_seq_generator")
    @SequenceGenerator(name = "mi_seq_generator", sequenceName = "MI_SEQ", allocationSize = 1)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaHora;

    private String motivoCita;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
    private Diagnostico diagnostico;
}