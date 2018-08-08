package com.netcracker.edu.smartgreenhouse.server.exception;

public class NotImplementedException extends ServerException {
    public NotImplementedException() {
        super("Not implemented yet");
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
