package inventario.Ey.backend.GestionArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Area createArea(AreaDTO areaDTO) {
        if (areaRepository.findByNombre(areaDTO.getNombre()).isPresent()) {
            throw new AreaAlreadyExistsException("El área con nombre '" + areaDTO.getNombre() + "' ya existe.");
        }
        Area area = new Area();
        area.setNombre(areaDTO.getNombre());
        area.setTipo(areaDTO.getTipo());
        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(Long id, AreaDTO areaDTO) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new AreaNotFoundException("Área no encontrada"));
        if (!area.getNombre().equals(areaDTO.getNombre()) && areaRepository.findByNombre(areaDTO.getNombre()).isPresent()) {
            throw new AreaAlreadyExistsException("El área con nombre '" + areaDTO.getNombre() + "' ya existe.");
        }
        area.setNombre(areaDTO.getNombre());
        area.setTipo(areaDTO.getTipo());
        return areaRepository.save(area);
    }

    @Override
    public void deleteArea(Long id) {
        if (!areaRepository.existsById(id)) {
            throw new AreaNotFoundException("Área no encontrada");
        }
        areaRepository.deleteById(id);
    }

    @Override
    public Area getAreaById(Long id) {
        return areaRepository.findById(id).orElseThrow(() -> new AreaNotFoundException("Área no encontrada"));
    }

    @Override
    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    @Override
    public List<Area> getAreasOrderedByNombreDesc() {
        return areaRepository.findAllOrderedByNombreDesc();
    }
}
