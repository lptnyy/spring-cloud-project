package com.wzy.common.exception;
import com.wzy.common.util.ServiceResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public Object exceptionHandler(Exception e){
        return ServiceResponse.getFAIL();
    }
}
