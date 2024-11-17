package inventario.Ey.backend.GestionAsignacionEquipos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AsignacionEquipoDTO {
    private Long id;

    @NotBlank(message = "El nombre del área no puede estar vacío")
    private String areaNombre;

    @NotBlank(message = "El nombre del equipo no puede estar vacío")
    private String equipoNombre;

    @NotBlank(message = "El nombre del funcionario no puede estar vacío")
    private String funcionarioNombre;

    @NotNull(message = "La fecha de asignación no puede estar vacía")
    private LocalDate fechaAsignacion;
}
