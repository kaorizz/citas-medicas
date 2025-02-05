package citas_medicas.dominio;

import jakarta.persistence.*;
import lombok.*;
import utils.Utils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;
}
