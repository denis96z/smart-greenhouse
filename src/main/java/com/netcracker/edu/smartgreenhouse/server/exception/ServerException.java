package com.netcracker.edu.smartgreenhouse.server.exception;

public class ServerException extends RuntimeException {
    private String message;

    ServerException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
