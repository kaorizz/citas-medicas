package citas_medicas.dominio;

import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.PacienteDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Paciente extends Usuario {

    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

    public Paciente(String nombre, String apellidos, String usuario, String clave, String NSS, String numTarjeta, String telefono, String direccion) {
        super(nombre, apellidos, usuario, clave);
        this.NSS = NSS;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Metodo para convertir un Paciente en un PacienteDTO
    public PacienteDTO toDTO() {
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita c : this.citas) {
            citasDTO.add(c.toDTO());
        }
        return new PacienteDTO(getId(), getNombre(), getApellidos(), getUsuario(), getClave(), this.NSS, this.numTarjeta, this.telefono, this.direccion, citasDTO);
    }
}