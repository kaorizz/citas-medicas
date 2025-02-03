package citas_medicas.dominio;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico extends Usuario {
    private String numColegiado;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

    // Constructor vacío
    public Medico() {}

    // Constructor con todos los campos
    public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
        super(nombre, apellidos, usuario, clave); // Llama al constructor de Usuario
        this.numColegiado = numColegiado;
        this.citas = new ArrayList<Cita>();
    }

    // Getters y setters
    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numColegiado='" + numColegiado + '\'' +
                '}';
    }

}
