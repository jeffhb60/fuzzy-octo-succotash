package com.jeffhb60.ecomshoppingcart.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;

@NoArgsConstructor
public class APIException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public APIException(String message) {
        super(message);
    }
}
