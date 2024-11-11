package inventario.Ey.backend.GestionUsuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO);
    FuncionarioDTO updateFuncionario(Long id, FuncionarioDTO funcionarioDTO);
    FuncionarioDTO getFuncionarioById(Long id);

    List<FuncionarioDTO> getAllFuncionarios();

    void deleteFuncionario(Long id);

    Optional<FuncionarioDTO> getByIdentificacion(String identificacion);


    Page<FuncionarioDTO> getFuncionariosPaginated(Pageable pageable);
}
