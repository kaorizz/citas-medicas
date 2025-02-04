package citas_medicas.repositorio;

import citas_medicas.dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPacientes extends JpaRepository<Paciente, String> {
}