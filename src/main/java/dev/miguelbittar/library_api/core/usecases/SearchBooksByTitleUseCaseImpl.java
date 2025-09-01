package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;
import dev.miguelbittar.library_api.infra.exceptions.BooksNotFoundException;

import java.util.List;

public class SearchBooksByTitleUseCaseImpl implements SearchBooksByTitleUseCase{

    private final BookGateway bookGateway;

    public SearchBooksByTitleUseCaseImpl(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public List<Book> execute(String title){
        List<Book> books = bookGateway.findByTitle(title);

        if (books.isEmpty()) {
            throw new BooksNotFoundException("title: " + title);
        }
        return books;
    }

}
