package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;

import java.util.List;

public class SearchBooksByTitleUseCaseImpl implements SearchBooksByTitleUseCase{

    private final BookGateway bookGateway;

    public SearchBooksByTitleUseCaseImpl(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public List<Book> execute(String title){
        return bookGateway.findByTitle(title);
    }

}
