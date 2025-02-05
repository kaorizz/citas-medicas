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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // Metodo para convertir una Cita en un CitaDTO
    public CitaDTO toDTO() {
        return new CitaDTO(this.id, this.fechaHora, this.motivoCita,
                this.paciente.toDTO(), this.medico.toDTO(), this.diagnostico.toDTO());
    }
}