package inventario.Ey.backend.GestionUsuarios;

public class DuplicateIdentificacionException extends RuntimeException{
    private String identificacion;

    public DuplicateIdentificacionException(String identificacion) {
        super("Funcionario with identificacion " + identificacion + " already exists.");
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
