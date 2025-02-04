package citas_medicas.rest;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.servicio.ServicioMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicosController {

    @Autowired
    private ServicioMedicos servicioMedicos;

    @PostMapping("")
    public ResponseEntity<Medico> registrarMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(servicioMedicos.registrarMedico(medico));
    }

    @GetMapping("/{id}/citas")
    public ResponseEntity<List<Cita>> obtenerCitasMedico(@PathVariable String id) {
        return ResponseEntity.ok(servicioMedicos.obtenerCitasMedico(id));
    }
}