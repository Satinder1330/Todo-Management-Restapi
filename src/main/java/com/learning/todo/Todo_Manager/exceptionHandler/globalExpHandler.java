package com.learning.todo.Todo_Manager.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class globalExpHandler {

    Logger logger = LoggerFactory.getLogger(globalExpHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> mainHandler(Exception ex){
       logger.error("Eception Handling from global {} ",ex.getMessage());
       logger.info("stack trace : {}",ex.getStackTrace());
       return new ResponseEntity<>("Exception Handeling from global", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ResourceNotFoundExp.class)
    public ResponseEntity<CustomResponse> customException(ResourceNotFoundExp ex){
        CustomResponse response = new CustomResponse();
        response.setMessage(ex.getMessage());
        response.setStatus(ex.getStatus());
        response.setSuccess(Boolean.FALSE);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
