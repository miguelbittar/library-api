package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;

import java.util.List;

public class GetAllBooksUseCaseImpl implements GetAllBooksUseCase{

    private final BookGateway bookGateway;

    public GetAllBooksUseCaseImpl(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public List<Book> execute(){
        return bookGateway.getAllBooks();
    }

}
