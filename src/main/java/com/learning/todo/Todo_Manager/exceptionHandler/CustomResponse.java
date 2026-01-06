package com.learning.todo.Todo_Manager.exceptionHandler;

import org.springframework.http.HttpStatus;

public class CustomResponse {
    private  String message;
    private HttpStatus status;
    private Boolean success;

    public CustomResponse(Boolean success, HttpStatus status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public CustomResponse() {
    }

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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
