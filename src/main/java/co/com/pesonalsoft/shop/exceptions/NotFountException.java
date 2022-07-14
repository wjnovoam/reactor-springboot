package co.com.pesonalsoft.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author William Johan Novoa Melendrez
 * @date 12/07/2022
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFountException extends RuntimeException{
    private static final long serialVersionUID= 1L;

    public NotFountException(String message) {
        super(message);
    }



}