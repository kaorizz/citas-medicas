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
    public ResponseEntity<MedicoDTO> registrarMedico(@RequestBody Medico medico) {
        Medico nuevoMedico = servicioMedicos.registrarMedico(medico);
        return ResponseEntity.ok(nuevoMedico.toDTO());
    }

    @GetMapping("/{id}/citas")
    public ResponseEntity<List<CitaDTO>> obtenerCitasMedico(@PathVariable String id) {
        List<Cita> citas = servicioMedicos.obtenerCitasMedico(id);
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(cita.toDTO());
        }
        return ResponseEntity.ok(citasDTO);
    }
}