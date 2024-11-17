package inventario.Ey.backend.GestionAsignacionEquipos;

import inventario.Ey.backend.GestionArea.Area;
import inventario.Ey.backend.GestionArea.AreaRepository;
import inventario.Ey.backend.GestionEquipos.Equipo;
import inventario.Ey.backend.GestionEquipos.EquipoRepository;
import inventario.Ey.backend.GestionUsuarios.Funcionario;
import inventario.Ey.backend.GestionUsuarios.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignacionEquipoServiceImpl implements AsignacionEquipoService{
    @Autowired
    private AsignacionEquipoRepository asignacionEquipoRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<AsignacionEquipoDTO> obtenerTodasLasAsignaciones() {
        return asignacionEquipoRepository.findAll().stream()
                .map(AsignacionEquipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsignacionEquipoDTO obtenerAsignacionPorId(Long id) {
        AsignacionEquipo asignacion = obtenerAsignacionPorIdInterno(id);
        return AsignacionEquipoMapper.toDTO(asignacion);
    }

    @Override
    public AsignacionEquipoDTO crearAsignacion(AsignacionEquipoDTO asignacionDTO) {
        // Obtiene entidades relacionadas
        Area area = obtenerAreaPorNombre(asignacionDTO.getAreaNombre());
        Equipo equipo = obtenerEquipoPorNombre(asignacionDTO.getEquipoNombre());
        Funcionario funcionario = obtenerFuncionarioPorNombre(asignacionDTO.getFuncionarioNombre());

        // Crea una nueva asignación
        AsignacionEquipo nuevaAsignacion = AsignacionEquipoMapper.toEntity(asignacionDTO, area, equipo, funcionario);
        nuevaAsignacion = asignacionEquipoRepository.save(nuevaAsignacion);

        return AsignacionEquipoMapper.toDTO(nuevaAsignacion);
    }

    @Override
    public AsignacionEquipoDTO actualizarAsignacion(Long id, AsignacionEquipoDTO asignacionDTO) {
        AsignacionEquipo asignacionExistente = obtenerAsignacionPorIdInterno(id);

        // Actualiza las referencias y datos
        asignacionExistente.setArea(obtenerAreaPorNombre(asignacionDTO.getAreaNombre()));
        asignacionExistente.setEquipo(obtenerEquipoPorNombre(asignacionDTO.getEquipoNombre()));
        asignacionExistente.setFuncionario(obtenerFuncionarioPorNombre(asignacionDTO.getFuncionarioNombre()));
        asignacionExistente.setFechaAsignacion(asignacionDTO.getFechaAsignacion());

        asignacionExistente = asignacionEquipoRepository.save(asignacionExistente);
        return AsignacionEquipoMapper.toDTO(asignacionExistente);
    }

    @Override
    public void eliminarAsignacion(Long id) {
        if (!asignacionEquipoRepository.existsById(id)) {
            throw new EntityNotFoundException("La asignación con ID " + id + " no fue encontrada.");
        }
        asignacionEquipoRepository.deleteById(id);
    }

    // Métodos privados para reducir duplicación de código
    private AsignacionEquipo obtenerAsignacionPorIdInterno(Long id) {
        return asignacionEquipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asignación no encontrada para el ID " + id));
    }

    private Area obtenerAreaPorNombre(String nombre) {
        return areaRepository.findByNombre(nombre)
                .orElseThrow(() -> new EntityNotFoundException("Área no encontrada: " + nombre));
    }

    private Equipo obtenerEquipoPorNombre(String nombre) {
        return equipoRepository.findByNombre(nombre)
                .orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado: " + nombre));
    }

    private Funcionario obtenerFuncionarioPorNombre(String nombre) {
        return funcionarioRepository.findByNombreFuncionario(nombre)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario no encontrado: " + nombre));
    }
}
