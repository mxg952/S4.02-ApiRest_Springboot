package cat.itacademy.s04.t02.n01_n02.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Maneja excepciones personalizadas como FruitaNotFoundException
    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<Object> handleFruitNotFoundException(FruitNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage()); // Mensaje definido al lanzar la excepción.

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND); // Retorna 404 Not Found.
    }

    // Manejo genérico para excepciones no previstas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Ocurrió un error interno en la aplicación.");
        body.put("details", ex.getMessage()); // Para depuración: detalles del error.

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR); // Retorna 500 Internal Server Error.
    }
    
}
