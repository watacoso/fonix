package com.fonix.api;


import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.io.InvalidObjectException;
import java.sql.SQLException;


@ControllerAdvice
public class ControllerExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);


    @ExceptionHandler({InvalidObjectException.class, InvalidDefinitionException.class})
    public final ResponseEntity<ApiError> handlInvalidObjectException(Exception ex, WebRequest req) {

        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        ApiError body = new ApiError("Invalid input");
        return buildResponse(ex, status, body, req);

    }

    @ExceptionHandler({SQLException.class, NullPointerException.class})
    public final ResponseEntity<ApiError> handleGenericException(Exception ex, WebRequest req) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError body = new ApiError("Internal server error");

        return buildResponse(ex, status, body, req);

    }


    private ResponseEntity<ApiError> buildResponse(Exception ex, HttpStatus status, ApiError body, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        logger.error(ex.getMessage());
        return new ResponseEntity<>(body, headers, status);
    }

}
