package inventario.Ey.backend.GestionAsignacionEquipos;

import inventario.Ey.backend.GestionArea.Area;
import inventario.Ey.backend.GestionEquipos.Equipo;
import inventario.Ey.backend.GestionUsuarios.Funcionario;

public class AsignacionEquipoMapper {
    /**
     * Convierte una entidad AsignacionEquipo a su DTO correspondiente.
     *
     * @param asignacion La entidad AsignacionEquipo.
     * @return El DTO AsignacionEquipoDTO.
     */
    public static AsignacionEquipoDTO toDTO(AsignacionEquipo asignacion) {
        if (asignacion == null) {
            return null;
        }

        AsignacionEquipoDTO dto = new AsignacionEquipoDTO();
        dto.setId(asignacion.getId()); // ID de la asignación

        // Mapeo de nombres con manejo de nulos
        dto.setAreaNombre(asignacion.getArea() != null ? asignacion.getArea().getNombre() : null); // Nombre del área
        dto.setEquipoNombre(asignacion.getEquipo() != null ? asignacion.getEquipo().getNombre() : null); // Nombre del equipo
        dto.setFuncionarioNombre(asignacion.getFuncionario() != null ? asignacion.getFuncionario().getNombreFuncionario() : null); // Nombre del funcionario

        dto.setFechaAsignacion(asignacion.getFechaAsignacion()); // Fecha de asignación
        return dto;
    }

    /**
     * Convierte un DTO AsignacionEquipoDTO a su entidad correspondiente.
     *
     * @param dto         El DTO AsignacionEquipoDTO.
     * @param area        La entidad Area relacionada.
     * @param equipo      La entidad Equipo relacionada.
     * @param funcionario La entidad Funcionario relacionada.
     * @return La entidad AsignacionEquipo.
     */
    public static AsignacionEquipo toEntity(AsignacionEquipoDTO dto, Area area, Equipo equipo, Funcionario funcionario) {
        if (dto == null || area == null || equipo == null || funcionario == null) {
            throw new IllegalArgumentException("DTO, Area, Equipo y Funcionario no pueden ser nulos.");
        }

        AsignacionEquipo asignacion = new AsignacionEquipo();

        // Relaciones principales
        asignacion.setArea(area);
        asignacion.setEquipo(equipo);
        asignacion.setFuncionario(funcionario);

        // Campos redundantes (nombres)
        asignacion.setNombreArea(area.getNombre());
        asignacion.setNombreEquipo(equipo.getNombre());
        asignacion.setNombreFuncionario(funcionario.getNombreFuncionario());

        // Otros campos
        asignacion.setFechaAsignacion(dto.getFechaAsignacion());

        return asignacion;
    }
}
