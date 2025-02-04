package citas_medicas.repositorio;

import citas_medicas.dominio.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDiagnosticos extends JpaRepository<Diagnostico, String> {
}