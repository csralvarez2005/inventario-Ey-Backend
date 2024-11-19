package inventario.Ey.backend.GestionUsuarios;

import inventario.Ey.backend.GestionAsignacionEquipos.AsignacionEquipo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionarios")
@NoArgsConstructor
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioId;
    @Column(unique = true)
    private String identificacion;
    private String nombreFuncionario;
    private String apellidoFuncionario;
    private String celular;
    private String direccion;
    private String email;
    private String estado;
    private LocalDate fechaNacimiento;
    private String cargo;
    private String estadoCivil;
    private String genero;
    private String TipoDocumento;


}
