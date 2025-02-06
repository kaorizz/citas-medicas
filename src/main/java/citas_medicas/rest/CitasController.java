package citas_medicas.rest;

import citas_medicas.dominio.Cita;
import citas_medicas.dto.CitaDTO;
import citas_medicas.servicio.ServicioCitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    @Autowired
    private ServicioCitas servicioCitas;

    @PostMapping("")
    public ResponseEntity<?> agendarCita(@RequestParam String pacienteId,
                                         @RequestParam String medicoId,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora) {
        try {
            CitaDTO cita = servicioCitas.agendarCita(pacienteId, medicoId, fechaHora);
            return ResponseEntity.ok(cita);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarCita(@PathVariable String id) {
        servicioCitas.cancelarCita(id);
        return ResponseEntity.ok("Cita cancelada correctamente");
    }
}