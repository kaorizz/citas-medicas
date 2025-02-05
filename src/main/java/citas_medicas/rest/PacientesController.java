package citas_medicas.rest;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Paciente;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.PacienteDTO;
import citas_medicas.servicio.ServicioPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacientesController {

    @Autowired
    private ServicioPacientes servicioPacientes;

    @PostMapping("")
    public ResponseEntity<PacienteDTO> registrarPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = servicioPacientes.registrarPaciente(paciente);
        return ResponseEntity.ok(nuevoPaciente.toDTO());
    }

    @GetMapping("/{id}/citas")
    public ResponseEntity<List<CitaDTO>> obtenerCitasPaciente(@PathVariable String id) {
        List<Cita> citas = servicioPacientes.obtenerCitasPaciente(id);
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(cita.toDTO());
        }
        return ResponseEntity.ok(citasDTO);
    }
}