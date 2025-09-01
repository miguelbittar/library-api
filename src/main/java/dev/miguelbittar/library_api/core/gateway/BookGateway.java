package dev.miguelbittar.library_api.core.gateway;

import dev.miguelbittar.library_api.core.entities.Book;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookGateway {
    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public List<Book> findByTitle(String title);
    public Optional<Book> findById(Long id);
    Book save(Book book);

}
