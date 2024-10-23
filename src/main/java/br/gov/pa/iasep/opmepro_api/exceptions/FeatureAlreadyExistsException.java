package br.gov.pa.iasep.opmepro_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FeatureAlreadyExistsException extends RuntimeException {
    public FeatureAlreadyExistsException(String message) {
        super(message);
    }
}
