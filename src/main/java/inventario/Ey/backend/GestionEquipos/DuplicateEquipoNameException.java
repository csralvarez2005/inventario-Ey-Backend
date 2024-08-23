package inventario.Ey.backend.GestionEquipos;

public class DuplicateEquipoNameException extends RuntimeException{
    public DuplicateEquipoNameException(String message) {
        super(message);
    }
}
