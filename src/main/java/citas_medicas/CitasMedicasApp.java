package citas_medicas;

import citas_medicas.dominio.Cita;
import citas_medicas.dominio.Diagnostico;
import citas_medicas.dominio.Medico;
import citas_medicas.dominio.Paciente;
import citas_medicas.dto.CitaDTO;
import citas_medicas.dto.DiagnosticoDTO;
import citas_medicas.dto.MedicoDTO;
import citas_medicas.dto.PacienteDTO;
import citas_medicas.servicio.ServicioCitas;
import citas_medicas.servicio.ServicioDiagnosticos;
import citas_medicas.servicio.ServicioMedicos;
import citas_medicas.servicio.ServicioPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class CitasMedicasApp implements CommandLineRunner {

    @Autowired
    private ServicioPacientes servicioPacientes;
    @Autowired
    private ServicioMedicos servicioMedicos;
    @Autowired
    private ServicioCitas servicioCitas;
    @Autowired
    private ServicioDiagnosticos servicioDiagnosticos;

    public static void main(String[] args) {
        SpringApplication.run(CitasMedicasApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("▶ Iniciando pruebas de la aplicación de citas médicas...");

        // 1️⃣ Crear y registrar pacientes
        //PacienteDTO paciente1 = new PacienteDTO(null, "Juan", "Pérez", "juanp", "1234", "123456789", "987654321", "666111222", "Calle A", null);
        //PacienteDTO paciente2 = new PacienteDTO(null, "María", "Gómez", "mariag", "1234", "987654321", "123456789", "666222333", "Calle B", null);

        //paciente1 = servicioPacientes.registrarPaciente(paciente1);
        //paciente2 = servicioPacientes.registrarPaciente(paciente2);

        // 2️⃣ Crear y registrar médicos
        //MedicoDTO medico1 = new MedicoDTO(null, "Dr. Carlos", "Sánchez", "carlos.s", "cardiología", "carlos@hospital.com", null);
        //MedicoDTO medico2 = new MedicoDTO(null, "Dra. Laura", "Martínez", "laura.m", "pediatría", "laura@hospital.com", null);

        //medico1 = servicioMedicos.registrarMedico(medico1);
        //medico2 = servicioMedicos.registrarMedico(medico2);

        // 3️⃣ Agendar citas
        //LocalDateTime fechaHoraCita1 = LocalDateTime.parse("2025-02-10T10:00");
        //LocalDateTime fechaHoraCita2 = LocalDateTime.parse("2025-02-10T11:00");


        //CitaDTO cita1 = servicioCitas.agendarCita(paciente1.getId().toString(), medico1.getId().toString(), fechaHoraCita1);
        //CitaDTO cita2 = servicioCitas.agendarCita(paciente2.getId().toString(), medico2.getId().toString(), fechaHoraCita2);

        // 4️⃣ Crear y registrar diagnósticos

        // Imprimir confirmación
        /*System.out.println("✔ Citas agendadas exitosamente:");
        System.out.println("Cita 1: " + cita1);
        System.out.println("Cita 2: " + cita2);*/
    }
}