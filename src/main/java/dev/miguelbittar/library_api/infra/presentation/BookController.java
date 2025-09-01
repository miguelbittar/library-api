package dev.miguelbittar.library_api.infra.presentation;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.usecases.CreateBookUseCase;
import dev.miguelbittar.library_api.infra.dtos.BookDto;
import dev.miguelbittar.library_api.infra.mapper.BookDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final BookDtoMapper bookDtoMapper;

    public BookController(CreateBookUseCase createBookUseCase, BookDtoMapper bookDtoMapper) {
        this.createBookUseCase = createBookUseCase;
        this.bookDtoMapper = bookDtoMapper;
    }

    @PostMapping("/books")
    public String createBook (@RequestBody BookDto bookDto){
        Book book = createBookUseCase.execute(bookDtoMapper.toEntity(bookDto));
        return "Livro registrado";
    };

}
