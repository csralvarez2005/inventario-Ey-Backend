package inventario.Ey.backend.GestionEquipos;

import java.util.List;

public interface EquipoService {
    List<EquipoDTO> findAll();
    EquipoDTO findById(Long id);
    EquipoDTO create(EquipoDTO equipoDTO);
    EquipoDTO update(Long id, EquipoDTO equipoDTO);
    void delete(Long id);
}
