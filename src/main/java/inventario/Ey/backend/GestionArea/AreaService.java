package inventario.Ey.backend.GestionArea;

import java.util.List;

public interface AreaService {
    Area createArea(AreaDTO areaDTO);
    Area updateArea(Long id, AreaDTO areaDTO);
    void deleteArea(Long id);
    Area getAreaById(Long id);
    List<Area> getAllAreas();
}
