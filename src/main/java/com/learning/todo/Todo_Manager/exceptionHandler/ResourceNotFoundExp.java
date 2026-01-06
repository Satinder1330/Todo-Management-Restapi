package com.learning.todo.Todo_Manager.exceptionHandler;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundExp extends RuntimeException{
    private  String message;
    private HttpStatus status;

    public ResourceNotFoundExp(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public ResourceNotFoundExp() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
