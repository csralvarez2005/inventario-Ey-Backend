package inventario.Ey.backend.GestionEquipos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EquipoDTO {
    private Long id;
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
