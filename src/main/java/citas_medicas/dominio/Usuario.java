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

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mi_seq_generator")
    @SequenceGenerator(name = "mi_seq_generator", sequenceName = "MI_SEQ", allocationSize = 1)
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;
}
