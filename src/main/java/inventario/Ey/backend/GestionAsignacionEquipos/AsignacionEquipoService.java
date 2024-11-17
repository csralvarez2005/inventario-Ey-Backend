package inventario.Ey.backend.GestionAsignacionEquipos;

import java.util.List;

public interface AsignacionEquipoService {

    List<AsignacionEquipoDTO> obtenerTodasLasAsignaciones();
    AsignacionEquipoDTO obtenerAsignacionPorId(Long id);
    AsignacionEquipoDTO crearAsignacion(AsignacionEquipoDTO asignacionDTO);
    AsignacionEquipoDTO actualizarAsignacion(Long id, AsignacionEquipoDTO asignacionDTO);
    void eliminarAsignacion(Long id);


}
