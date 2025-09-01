package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;
import dev.miguelbittar.library_api.infra.exceptions.BookAlreadyExistsException;
import org.springframework.dao.DataIntegrityViolationException;

public class CreateBookUseCaseImpl implements CreateBookUseCase{

    private final BookGateway bookGateway;

    public CreateBookUseCaseImpl(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public Book execute(Book book){
        try {
            return bookGateway.createBook(book);
        } catch (DataIntegrityViolationException e) {
            throw new BookAlreadyExistsException(book.isbn());
        }
    }
}
