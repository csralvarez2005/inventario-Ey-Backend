package inventario.Ey.backend;

import inventario.Ey.backend.GestionEquipos.DuplicateEquipoNameException;
import inventario.Ey.backend.GestionUsuarios.DuplicateIdentificacionException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejar la excepción DuplicateEquipoNameException
    @ExceptionHandler(DuplicateEquipoNameException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEquipoNameException(DuplicateEquipoNameException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("DuplicateEquipoNameException", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Manejar la excepción DuplicateIdentificacionException
    @ExceptionHandler(DuplicateIdentificacionException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateIdentificacionException(DuplicateIdentificacionException ex, WebRequest request) {
        String message = "El funcionario con la identificación " + ex.getIdentificacion() + " ya existe.";
        ErrorResponse errorResponse = new ErrorResponse("DuplicateIdentificacionException", message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Manejar la excepción EntityNotFoundException (cuando no se encuentra la entidad)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("EntityNotFoundException", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Manejar excepciones de violación de integridad de datos (como claves duplicadas)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("DataIntegrityViolationException", "Violación de integridad de datos, probablemente clave duplicada.");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // Manejar excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("InternalServerError", "Ha ocurrido un error inesperado. Por favor intente de nuevo.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Clase de respuesta estándar para errores
    public static class ErrorResponse {
        private String errorType;
        private String message;

        public ErrorResponse(String errorType, String message) {
            this.errorType = errorType;
            this.message = message;
        }

        public String getErrorType() {
            return errorType;
        }

        public void setErrorType(String errorType) {
            this.errorType = errorType;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}


