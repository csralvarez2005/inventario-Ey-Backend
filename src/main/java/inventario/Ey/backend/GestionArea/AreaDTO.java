package inventario.Ey.backend.GestionArea;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AreaDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;
}
