package dev.miguelbittar.library_api.core.gateway;

import dev.miguelbittar.library_api.core.entities.Book;

public interface BookGateway {
    public Book createBook(Book book);
}
