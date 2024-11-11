package inventario.Ey.backend.GestionUsuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Método para encontrar un funcionario por identificación
    Optional<Funcionario> findByIdentificacion(String identificacion);

    // Método para obtener todos los funcionarios con paginación
    Page<Funcionario> findAll(Pageable pageable);
}
