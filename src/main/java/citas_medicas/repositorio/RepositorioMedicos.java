package citas_medicas.repositorio;

import citas_medicas.dominio.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMedicos extends JpaRepository<Medico, String> {
}