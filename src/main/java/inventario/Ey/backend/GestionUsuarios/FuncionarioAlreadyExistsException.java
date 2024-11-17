package inventario.Ey.backend.GestionUsuarios;

public class FuncionarioAlreadyExistsException extends RuntimeException {
    public FuncionarioAlreadyExistsException(String message) {
        super(message);
    }
}
