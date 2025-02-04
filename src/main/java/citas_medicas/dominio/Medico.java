package citas_medicas.dominio;

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
public class Medico extends Usuario {
    // Getters y setters
    private String numColegiado;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

    // Constructor con todos los campos
    public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
        super(nombre, apellidos, usuario, clave); // Llama al constructor de Usuario
        this.numColegiado = numColegiado;
        this.citas = new ArrayList<Cita>();
    }
}