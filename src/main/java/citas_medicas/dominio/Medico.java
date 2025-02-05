package citas_medicas.dominio;

import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.MedicoDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medico extends Usuario {

    private String numColegiado;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;
    @ManyToMany(mappedBy = "medicos")
    private List<Paciente> medicos;

    // Metodo para convertir un Medico en un MedicoDTO
    public MedicoDTO toDTO() {
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita c : this.citas) {
            citasDTO.add(c.toDTO());
        }
        return new MedicoDTO(getId(), getNombre(), getApellidos(), getUsuario(), getClave(), this.numColegiado, citasDTO);
    }
}