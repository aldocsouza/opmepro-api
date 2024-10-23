package br.gov.pa.iasep.opmepro_api.exceptions.ExceptionGlobalConfig;

import br.gov.pa.iasep.opmepro_api.exceptions.FeatureAlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.UnauthorizedException;
import br.gov.pa.iasep.opmepro_api.exceptions.UserAlreadyExistsException;
import br.gov.pa.iasep.opmepro_api.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> unauthorizedException(UnauthorizedException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeatureAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleFeatureAlreadyExistsException(FeatureAlreadyExistsException ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
