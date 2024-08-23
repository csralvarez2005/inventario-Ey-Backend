package inventario.Ey.backend.GestionEquipos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "equipos")
@NoArgsConstructor
@Data
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;
    private String serie;
    private String modelo;
    private String tipo;
    private LocalDate fechaDeCompra;
    private String marca;
    private String proveedor;
    private String factura;
    private String garantia;
    private LocalDate fechaFinGarantia;
    private String recibidoPor;
    private String ordenDeCompra;
    private String ubicacionDelEquipo;
    private String descripcion;
    private String componentes;
    private String accesorios;
    private String utilizacion;
    private Double precio;
}
