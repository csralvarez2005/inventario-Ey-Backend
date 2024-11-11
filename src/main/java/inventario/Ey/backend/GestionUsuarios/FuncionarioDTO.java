package inventario.Ey.backend.GestionUsuarios;

import lombok.Data;

import java.time.LocalDate;
@Data
public class FuncionarioDTO {

    private Long id;
    private String identificacion;
    private String nombreFuncionario;
    private String apellidoFuncionario;
    private String celular;
    private String direccion;
    private String email;
    private String estado;
    private LocalDate fechaNacimiento;
    private String cargo;         // Se cambió a camelCase
    private String estadoCivil;    // Se cambió a camelCase
    private String genero;         // Se cambió a camelCase
    private String tipoDocumento;


}
