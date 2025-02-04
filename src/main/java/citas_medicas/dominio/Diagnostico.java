package citas_medicas.dominio;

import citas_medicas.dto.DiagnosticoDTO;
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

    // Metodo para convertir un Diagnostico en un DiagnosticoDTO
    public DiagnosticoDTO toDTO() {
        return new DiagnosticoDTO(this.id, this.valoracionEspecialista, this.enfermedad, this.cita.toDTO());
    }
}
