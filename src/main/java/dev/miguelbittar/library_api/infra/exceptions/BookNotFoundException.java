package dev.miguelbittar.library_api.infra.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {

        super("Book with ID " + id + " not found");
    }
}
