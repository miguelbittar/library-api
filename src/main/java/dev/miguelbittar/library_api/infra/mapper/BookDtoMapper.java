package dev.miguelbittar.library_api.infra.mapper;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.infra.dtos.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookDtoMapper {

    public Book toEntity(BookDto bookDto) {
        return new Book(
                bookDto.id(),
                bookDto.title(),
                bookDto.description(),
                bookDto.isbn(),
                bookDto.availableCopies(),
                bookDto.author(),
                bookDto.category(),
                bookDto.publisher()
        );
    }

    public BookDto toDto(Book book){
        return new BookDto(
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
}
