package citas_medicas.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private String id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    private List<CitaDTO> citas;
}