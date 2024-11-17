package inventario.Ey.backend.GestionUsuarios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Buscar por identificación
    Optional<Funcionario> findByIdentificacion(String identificacion);

    // Buscar por nombreFuncionario (corregido)
    Optional<Funcionario> findByNombreFuncionario(String nombreFuncionario);


}
