package inventario.Ey.backend.GestionAsignacionEquipos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import inventario.Ey.backend.GestionArea.Area;
import inventario.Ey.backend.GestionEquipos.Equipo;
import inventario.Ey.backend.GestionUsuarios.Funcionario;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "asignacionequipos")
@NoArgsConstructor
@Getter
@Setter
public class AsignacionEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    @JsonBackReference
    private Area area;

    @Column(name = "nombre_area")
    private String nombreArea;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @Column(name = "nombre_equipo")
    private String nombreEquipo;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Column(name = "nombre_funcionario")
    private String nombreFuncionario;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;
}
