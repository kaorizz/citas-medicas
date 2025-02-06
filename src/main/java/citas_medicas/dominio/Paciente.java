package citas_medicas.dominio;

import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.PacienteDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente extends Usuario {

    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;
    @ManyToMany
    @JoinTable(
            name = "paciente_medico",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "paciente_id"),  // Columna que referencia a Paciente
            inverseJoinColumns = @JoinColumn(name = "medico_id")  // Columna que referencia a Medico
    )
    private List<Paciente> medicos;
}