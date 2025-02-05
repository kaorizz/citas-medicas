package citas_medicas.rest;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Diagnostico;
import citas_medicas.dto.CitaDTO;
import citas_medicas.servicio.ServicioDiagnosticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticosController {

    @Autowired
    private ServicioDiagnosticos serviciosDiagnosticos;

    @PostMapping("/{idCita}/diagnostico")
    public ResponseEntity<CitaDTO> realizarDiagnostico(@PathVariable String idCita, @RequestParam Diagnostico diagnostico) {
        Cita cita = serviciosDiagnosticos.realizarDiagnostico(idCita, diagnostico);
        return ResponseEntity.ok(cita.toDTO());
    }
}