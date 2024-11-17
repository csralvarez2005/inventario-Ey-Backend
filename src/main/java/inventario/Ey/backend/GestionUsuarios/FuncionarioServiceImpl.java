package inventario.Ey.backend.GestionUsuarios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            throw new RuntimeException("El funcionario con identificación " + funcionarioDTO.getIdentificacion() + " ya existe.");
        }

        Funcionario funcionario = mapToEntity(funcionarioDTO);
        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);
        return mapToDTO(savedFuncionario);
    }

    @Override
    public FuncionarioDTO updateFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario no encontrado con ID " + id));

        funcionario.setNombreFuncionario(funcionarioDTO.getNombreFuncionario());
        funcionario.setApellidoFuncionario(funcionarioDTO.getApellidoFuncionario());
        funcionario.setCelular(funcionarioDTO.getCelular());
        funcionario.setDireccion(funcionarioDTO.getDireccion());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setEstado(funcionarioDTO.getEstado());
        funcionario.setFechaNacimiento(funcionarioDTO.getFechaNacimiento());
        funcionario.setCargo(funcionarioDTO.getCargo());
        funcionario.setEstadoCivil(funcionarioDTO.getEstadoCivil());
        funcionario.setGenero(funcionarioDTO.getGenero());
        funcionario.setTipoDocumento(funcionarioDTO.getTipoDocumento());

        Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
        return mapToDTO(updatedFuncionario);
    }

    @Override
    public FuncionarioDTO getFuncionarioById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario no encontrado con ID " + id));
        return mapToDTO(funcionario);
    }

    @Override
    public List<FuncionarioDTO> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario no encontrado con ID " + id));
        funcionarioRepository.delete(funcionario);
    }

    private Funcionario mapToEntity(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdentificacion(funcionarioDTO.getIdentificacion());
        funcionario.setNombreFuncionario(funcionarioDTO.getNombreFuncionario());
        funcionario.setApellidoFuncionario(funcionarioDTO.getApellidoFuncionario());
        funcionario.setCelular(funcionarioDTO.getCelular());
        funcionario.setDireccion(funcionarioDTO.getDireccion());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setEstado(funcionarioDTO.getEstado());
        funcionario.setFechaNacimiento(funcionarioDTO.getFechaNacimiento());
        funcionario.setCargo(funcionarioDTO.getCargo());
        funcionario.setEstadoCivil(funcionarioDTO.getEstadoCivil());
        funcionario.setGenero(funcionarioDTO.getGenero());
        funcionario.setTipoDocumento(funcionarioDTO.getTipoDocumento());
        return funcionario;
    }

    private FuncionarioDTO mapToDTO(Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setFuncionarioId(funcionario.getFuncionarioId());
        funcionarioDTO.setIdentificacion(funcionario.getIdentificacion());
        funcionarioDTO.setNombreFuncionario(funcionario.getNombreFuncionario());
        funcionarioDTO.setApellidoFuncionario(funcionario.getApellidoFuncionario());
        funcionarioDTO.setCelular(funcionario.getCelular());
        funcionarioDTO.setDireccion(funcionario.getDireccion());
        funcionarioDTO.setEmail(funcionario.getEmail());
        funcionarioDTO.setEstado(funcionario.getEstado());
        funcionarioDTO.setFechaNacimiento(funcionario.getFechaNacimiento());
        funcionarioDTO.setCargo(funcionario.getCargo());
        funcionarioDTO.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioDTO.setGenero(funcionario.getGenero());
        funcionarioDTO.setTipoDocumento(funcionario.getTipoDocumento());
        return funcionarioDTO;
    }

}
