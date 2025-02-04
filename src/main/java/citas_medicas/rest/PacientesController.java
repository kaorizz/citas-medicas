package citas_medicas.rest;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Paciente;
import citas_medicas.servicio.ServicioPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacientesController {

    @Autowired
    private ServicioPacientes servicioPacientes;

    @PostMapping("")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(servicioPacientes.registrarPaciente(paciente));
    }

    @GetMapping("/{id}/citas")
    public ResponseEntity<List<Cita>> obtenerCitasPaciente(@PathVariable String id) {
        return ResponseEntity.ok(servicioPacientes.obtenerCitasPaciente(id));
    }
}