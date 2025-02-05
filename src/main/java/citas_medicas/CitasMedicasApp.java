package citas_medicas;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Diagnostico;
import citas_medicas.dominio.Medico;
import citas_medicas.dominio.Paciente;
import citas_medicas.dto.PacienteDTO;
import citas_medicas.servicio.ServicioCitas;
import citas_medicas.servicio.ServicioDiagnosticos;
import citas_medicas.servicio.ServicioMedicos;
import citas_medicas.servicio.ServicioPacientes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

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

        /*Paciente paciente1 = new Paciente("Juan", "Pérez", "juan.perez", "12345", "3081785698", "P001", "682009652", "Calle Morera 20");
        Paciente paciente2 = new Paciente("María", "Gómez", "maria.gomez", "1234", "3081785170", "P002", "612840923", "Calle Mayor 4");

        Medico medico1 = new Medico("Pedro", "López", "pedro.lopez", "12345", "M001");
        Medico medico2 = new Medico("Ana", "Martínez", "ana.martinez", "1234", "M002");

        servicioPacientes.registrarPaciente(paciente1);
        servicioPacientes.registrarPaciente(paciente2);

        servicioMedicos.registrarMedico(medico1);
        servicioMedicos.registrarMedico(medico2);

        Cita cita1 = servicioCitas.agendarCita(paciente1.getId().toString(), medico1.getId().toString(), LocalDateTime.parse("2025-02-07T10:00:00"));
        Cita cita2 = servicioCitas.agendarCita(paciente2.getId().toString(), medico2.getId().toString(), LocalDateTime.parse("2025-02-07T11:00:00"));

        Diagnostico diagnostico1 = new Diagnostico("Gripe", "Tomar medicamento y reposo");
        servicioDiagnosticos.realizarDiagnostico(cita1.getId().toString(), diagnostico1);*/
    }
}