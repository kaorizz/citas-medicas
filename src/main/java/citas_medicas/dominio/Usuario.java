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
}
