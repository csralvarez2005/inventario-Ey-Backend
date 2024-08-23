package inventario.Ey.backend.GestionEquipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public List<EquipoDTO> findAll() {
        return equipoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDTO findById(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return convertToDTO(equipo);
    }

    @Override
    public EquipoDTO create(EquipoDTO equipoDTO) {
        if (equipoRepository.findByNombre(equipoDTO.getNombre()).isPresent()) {
            throw new DuplicateEquipoNameException("El equipo con el nombre '" + equipoDTO.getNombre() + "' ya existe.");
        }

        Equipo equipo = convertToEntity(equipoDTO);
        return convertToDTO(equipoRepository.save(equipo));
    }

    @Override
    public EquipoDTO update(Long id, EquipoDTO equipoDTO) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        equipo.setNombre(equipoDTO.getNombre());
        equipo.setSerie(equipoDTO.getSerie());
        equipo.setModelo(equipoDTO.getModelo());
        equipo.setTipo(equipoDTO.getTipo());
        equipo.setFechaDeCompra(equipoDTO.getFechaDeCompra());
        equipo.setMarca(equipoDTO.getMarca());
        equipo.setProveedor(equipoDTO.getProveedor());
        equipo.setFactura(equipoDTO.getFactura());
        equipo.setGarantia(equipoDTO.getGarantia());
        equipo.setFechaFinGarantia(equipoDTO.getFechaFinGarantia());
        equipo.setRecibidoPor(equipoDTO.getRecibidoPor());
        equipo.setOrdenDeCompra(equipoDTO.getOrdenDeCompra());
        equipo.setUbicacionDelEquipo(equipoDTO.getUbicacionDelEquipo());
        equipo.setDescripcion(equipoDTO.getDescripcion());
        equipo.setComponentes(equipoDTO.getComponentes());
        equipo.setAccesorios(equipoDTO.getAccesorios());
        equipo.setUtilizacion(equipoDTO.getUtilizacion());
        equipo.setPrecio(equipoDTO.getPrecio());

        return convertToDTO(equipoRepository.save(equipo));
    }

    @Override
    public void delete(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipoRepository.delete(equipo);
    }

    private EquipoDTO convertToDTO(Equipo equipo) {
        EquipoDTO dto = new EquipoDTO();
        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        dto.setSerie(equipo.getSerie());
        dto.setModelo(equipo.getModelo());
        dto.setTipo(equipo.getTipo());
        dto.setFechaDeCompra(equipo.getFechaDeCompra());
        dto.setMarca(equipo.getMarca());
        dto.setProveedor(equipo.getProveedor());
        dto.setFactura(equipo.getFactura());
        dto.setGarantia(equipo.getGarantia());
        dto.setFechaFinGarantia(equipo.getFechaFinGarantia());
        dto.setRecibidoPor(equipo.getRecibidoPor());
        dto.setOrdenDeCompra(equipo.getOrdenDeCompra());
        dto.setUbicacionDelEquipo(equipo.getUbicacionDelEquipo());
        dto.setDescripcion(equipo.getDescripcion());
        dto.setComponentes(equipo.getComponentes());
        dto.setAccesorios(equipo.getAccesorios());
        dto.setUtilizacion(equipo.getUtilizacion());
        dto.setPrecio(equipo.getPrecio());
        return dto;
    }

    private Equipo convertToEntity(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setSerie(equipoDTO.getSerie());
        equipo.setModelo(equipoDTO.getModelo());
        equipo.setTipo(equipoDTO.getTipo());
        equipo.setFechaDeCompra(equipoDTO.getFechaDeCompra());
        equipo.setMarca(equipoDTO.getMarca());
        equipo.setProveedor(equipoDTO.getProveedor());
        equipo.setFactura(equipoDTO.getFactura());
        equipo.setGarantia(equipoDTO.getGarantia()); // Integrating garantia
        equipo.setFechaFinGarantia(equipoDTO.getFechaFinGarantia());
        equipo.setRecibidoPor(equipoDTO.getRecibidoPor());
        equipo.setOrdenDeCompra(equipoDTO.getOrdenDeCompra());
        equipo.setUbicacionDelEquipo(equipoDTO.getUbicacionDelEquipo());
        equipo.setDescripcion(equipoDTO.getDescripcion());
        equipo.setComponentes(equipoDTO.getComponentes());
        equipo.setAccesorios(equipoDTO.getAccesorios());
        equipo.setUtilizacion(equipoDTO.getUtilizacion());
        equipo.setPrecio(equipoDTO.getPrecio());
        return equipo;
    }
}
