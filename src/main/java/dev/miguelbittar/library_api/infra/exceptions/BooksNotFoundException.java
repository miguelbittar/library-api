package dev.miguelbittar.library_api.infra.exceptions;

public class BooksNotFoundException extends RuntimeException {
    public BooksNotFoundException(String searchCriteria) {

        super("No books found matching: " + searchCriteria);
    }
}
