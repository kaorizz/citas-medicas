package citas_medicas;

import citas_medicas.dto.PacienteDTO;
import citas_medicas.servicio.ServicioCitas;
import citas_medicas.servicio.ServicioDiagnosticos;
import citas_medicas.servicio.ServicioMedicos;
import citas_medicas.servicio.ServicioPacientes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitasMedicasApp {

    private final ServicioPacientes servicioPacientes;
    private final ServicioMedicos servicioMedicos;
    private final ServicioCitas servicioCitas;
    private final ServicioDiagnosticos servicioDiagnosticos;

    public CitasMedicasApp(ServicioPacientes servicioPacientes, ServicioMedicos servicioMedicos,
                           ServicioCitas servicioCitas, ServicioDiagnosticos servicioDiagnosticos) {
        this.servicioPacientes = servicioPacientes;
        this.servicioMedicos = servicioMedicos;
        this.servicioCitas = servicioCitas;
        this.servicioDiagnosticos = servicioDiagnosticos;
    }

    public static void main(String[] args) {
        SpringApplication.run(CitasMedicasApp.class, args);
    }

    public void run(String... args) {
        System.out.println("▶ Iniciando pruebas de la aplicación de citas médicas...");


    }



}
