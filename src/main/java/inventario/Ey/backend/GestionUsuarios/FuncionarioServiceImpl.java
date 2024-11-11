package inventario.Ey.backend.GestionUsuarios;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> existingFuncionario = funcionarioRepository.findByIdentificacion(funcionarioDTO.getIdentificacion());

        if (existingFuncionario.isPresent()) {
            throw new DuplicateIdentificacionException("El funcionario con la identificación " + funcionarioDTO.getIdentificacion() + " ya existe.");
        }

        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioDTO, funcionario);
        funcionario = funcionarioRepository.save(funcionario);

        FuncionarioDTO responseDTO = new FuncionarioDTO();
        BeanUtils.copyProperties(funcionario, responseDTO);
        return responseDTO;
    }

    @Override
    public FuncionarioDTO updateFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario not found with id " + id));

        BeanUtils.copyProperties(funcionarioDTO, funcionario);
        funcionario = funcionarioRepository.save(funcionario);

        FuncionarioDTO responseDTO = new FuncionarioDTO();
        BeanUtils.copyProperties(funcionario, responseDTO);
        return responseDTO;
    }

    @Override
    public FuncionarioDTO getFuncionarioById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario not found with id " + id));

        FuncionarioDTO responseDTO = new FuncionarioDTO();
        BeanUtils.copyProperties(funcionario, responseDTO);
        return responseDTO;
    }

    @Override
    public List<FuncionarioDTO> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(funcionario -> {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            BeanUtils.copyProperties(funcionario, funcionarioDTO);
            return funcionarioDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario not found with id " + id));

        funcionarioRepository.delete(funcionario);
    }

    @Override
    public Optional<FuncionarioDTO> getByIdentificacion(String identificacion) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByIdentificacion(identificacion);

        if (funcionario.isPresent()) {
            FuncionarioDTO responseDTO = new FuncionarioDTO();
            BeanUtils.copyProperties(funcionario.get(), responseDTO);
            return Optional.of(responseDTO);
        } else {
            return Optional.empty();
        }
    }



    @Override
    public Page<FuncionarioDTO> getFuncionariosPaginated(Pageable pageable) {
        // Obtener una página de entidades Funcionario desde el repositorio
        Page<Funcionario> funcionariosPage = funcionarioRepository.findAll(pageable);

        // Mapear la página de entidades Funcionario a una página de DTOs FuncionarioDTO
        return funcionariosPage.map(funcionario -> {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            BeanUtils.copyProperties(funcionario, funcionarioDTO);
            return funcionarioDTO;
        });
    }


}
