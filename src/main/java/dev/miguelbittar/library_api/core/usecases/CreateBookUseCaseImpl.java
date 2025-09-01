package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;

public class CreateBookUseCaseImpl implements CreateBookUseCase{

    private final BookGateway bookGateway;

    public CreateBookUseCaseImpl(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public Book execute(Book book){
        return bookGateway.createBook(book);
    }
}
