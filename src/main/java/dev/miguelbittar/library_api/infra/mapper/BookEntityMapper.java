package dev.miguelbittar.library_api.infra.mapper;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.infra.persistence.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookEntityMapper {

    public BookEntity toEntity(Book book){
        return new BookEntity(
                book.id(),
                book.title(),
                book.description(),
                book.isbn(),
                book.availableCopies(),
                book.author(),
                book.category(),
                book.publisher()
        );
    }

    public Book toDomain(BookEntity bookEntity){
        return new Book(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getDescription(),
                bookEntity.getIsbn(),
                bookEntity.getAvailableCopies(),
                bookEntity.getAuthor(),
                bookEntity.getCategory(),
                bookEntity.getPublisher()
        );
    }
}
