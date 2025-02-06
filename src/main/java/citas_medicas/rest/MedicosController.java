package citas_medicas.rest;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Medico;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.MedicoDTO;
import citas_medicas.servicio.ServicioMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicosController {

    @Autowired
    private ServicioMedicos servicioMedicos;

    @PostMapping("")
    public ResponseEntity<MedicoDTO> registrarMedico(@RequestBody MedicoDTO medicoDTO) {
        MedicoDTO nuevoMedico = servicioMedicos.registrarMedico(medicoDTO);
        return ResponseEntity.ok(nuevoMedico);
    }

    @GetMapping("/{id}/citas")
    public ResponseEntity<List<CitaDTO>> obtenerCitasMedico(@PathVariable String id) {
        List<CitaDTO> citas = servicioMedicos.obtenerCitasMedico(id);
        return ResponseEntity.ok(citas);
    }
}