package citas_medicas.dominio;

import jakarta.persistence.*;
import utils.Utils;

import java.util.Date;

@Entity
public class Cita {
    @Id
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    private String motivoCita;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
    private Diagnostico diagnostico;

    // Constructor vacío
    public Cita() {}

    // Constructor con todos los campos
    public Cita(Date fechaHora, String motivoCita,
                Paciente paciente, Medico medico) {
        this.id = Utils.createId();
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.paciente = paciente;
        this.medico = medico;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id='" + id + '\'' +
                ", fechaHora=" + fechaHora +
                ", motivoCita='" + motivoCita + '\'' +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", diagnostico=" + diagnostico +
                '}';
    }
}
