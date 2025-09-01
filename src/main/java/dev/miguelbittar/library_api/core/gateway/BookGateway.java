package dev.miguelbittar.library_api.core.gateway;

import dev.miguelbittar.library_api.core.entities.Book;

import java.util.List;

public interface BookGateway {
    public Book createBook(Book book);
    public List<Book> getAllBooks();
}
