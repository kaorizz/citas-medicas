package citas_medicas.dominio;

import jakarta.persistence.*;
import utils.Utils;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;

    public Usuario(String nombre, String apellidos, String usuario, String clave) {
        this.id = Utils.createId();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Usuario() {}

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
