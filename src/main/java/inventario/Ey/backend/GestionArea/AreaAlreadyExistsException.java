package inventario.Ey.backend.GestionArea;

public class AreaAlreadyExistsException extends RuntimeException{

    public AreaAlreadyExistsException(String message) {
        super(message);
    }
}

