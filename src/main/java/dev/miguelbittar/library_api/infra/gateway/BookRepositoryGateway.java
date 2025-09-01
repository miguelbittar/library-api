package dev.miguelbittar.library_api.infra.gateway;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;
import dev.miguelbittar.library_api.infra.mapper.BookEntityMapper;
import dev.miguelbittar.library_api.infra.persistence.BookEntity;
import dev.miguelbittar.library_api.infra.persistence.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryGateway implements BookGateway {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    public BookRepositoryGateway(BookRepository bookRepository, BookEntityMapper bookEntityMapper) {
        this.bookRepository = bookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public Book createBook(Book book){
        BookEntity bookEntity = bookEntityMapper.toEntity(book);
        BookEntity newBook = bookRepository.save(bookEntity);
        return bookEntityMapper.toDomain(newBook);
    }
}
