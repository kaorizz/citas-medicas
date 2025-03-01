package citas_medicas.repositorio;

import citas_medicas.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, String> {
}