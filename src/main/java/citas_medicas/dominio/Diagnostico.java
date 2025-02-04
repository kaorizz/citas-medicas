package citas_medicas.dominio;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Utils;

@Data
@NoArgsConstructor
@Entity
public class Diagnostico {

    @Id
    private String id;
    private String valoracionEspecialista;
    private String enfermedad;

    @OneToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;

    // Constructor con todos los campos
    public Diagnostico(String valoracionEspecialista, String enfermedad, Cita cita) {
        this.id = Utils.createId();
        this.valoracionEspecialista = valoracionEspecialista;
        this.enfermedad = enfermedad;
        this.cita = cita;
    }
}
