package citas_medicas.dominio;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Utils;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Cita {

    @Id
    private String id;

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

    // Constructor con todos los campos
    public Cita(LocalDateTime fechaHora, String motivoCita,
                Paciente paciente, Medico medico) {
        this.id = Utils.createId();
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.paciente = paciente;
        this.medico = medico;
    }
}