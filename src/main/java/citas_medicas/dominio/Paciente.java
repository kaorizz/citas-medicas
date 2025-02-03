package citas_medicas.dominio;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Paciente extends Usuario {
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

    public Paciente() {
        super();
    }

    public Paciente(String nombre, String apellidos, String usuario, String clave, String NSS, String numTarjeta, String telefono, String direccion) {
        super(nombre, apellidos, usuario, clave);
        this.NSS = NSS;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y setters
    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "NSS='" + NSS + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
