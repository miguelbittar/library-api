package dev.miguelbittar.library_api.infra.exceptions;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String message) {

        super(message);
    }
}
