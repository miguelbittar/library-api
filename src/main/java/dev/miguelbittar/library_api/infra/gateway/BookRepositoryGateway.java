package dev.miguelbittar.library_api.infra.gateway;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;
import dev.miguelbittar.library_api.infra.mapper.BookEntityMapper;
import dev.miguelbittar.library_api.infra.persistence.BookEntity;
import dev.miguelbittar.library_api.infra.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepositoryGateway implements BookGateway {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    @Autowired
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

    @Override
    public List<Book> getAllBooks(){
        List<BookEntity> entities = bookRepository.findAll();
        return entities.stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<BookEntity> entities = bookRepository.findByTitleContainingIgnoreCase(title);
        return entities.stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Book> findById(Long id){
        return bookRepository.findById(id)
                .map(bookEntityMapper::toDomain);

    }

    @Override
    public Book save(Book book) {
        BookEntity entity = bookEntityMapper.toEntity(book);
        BookEntity saved = bookRepository.save(entity);
        return bookEntityMapper.toDomain(saved);
    }


}
