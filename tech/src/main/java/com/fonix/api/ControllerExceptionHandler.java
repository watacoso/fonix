package com.fonix.api;


import com.fonix.mail.MailTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;



@ControllerAdvice
public class ControllerExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    @ExceptionHandler({RuntimeException.class})
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest req){

        HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError body=new ApiError("Generic error");
        logger.error(ex.getMessage());
        return buildResponse(ex,status,body,req);

    }

    private ResponseEntity<ApiError> buildResponse(Exception ex, HttpStatus status,ApiError body,WebRequest request){
        HttpHeaders headers=new HttpHeaders();
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }

}
