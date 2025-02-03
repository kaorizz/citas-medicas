package citas_medicas.dominio;

import jakarta.persistence.*;
import utils.Utils;

@Entity
public class Diagnostico {
    @Id
    private String id;

    private String valoracionEspecialista;
    private String enfermedad;

    @OneToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;

    // Constructor vacío
    public Diagnostico() {}

    // Constructor con todos los campos
    public Diagnostico(String valoracionEspecialista, String enfermedad, Cita cita) {
        this.id = Utils.createId();
        this.valoracionEspecialista = valoracionEspecialista;
        this.enfermedad = enfermedad;
        this.cita = cita;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public void setValoracionEspecialista(String valoracionEspecialista) {
        this.valoracionEspecialista = valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "valoracionEspecialista='" + valoracionEspecialista + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                '}';
    }
}
