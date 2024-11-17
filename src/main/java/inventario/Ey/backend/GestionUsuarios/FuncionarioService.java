package inventario.Ey.backend.GestionUsuarios;

import java.util.List;


public interface FuncionarioService {

    FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO);
    FuncionarioDTO updateFuncionario(Long id, FuncionarioDTO funcionarioDTO);
    FuncionarioDTO getFuncionarioById(Long id);
    List<FuncionarioDTO> getAllFuncionarios();
    void deleteFuncionario(Long id);
}
