package dev.miguelbittar.library_api.infra.presentation;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.usecases.*;
import dev.miguelbittar.library_api.infra.dtos.BookDto;
import dev.miguelbittar.library_api.infra.mapper.BookDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final SearchBooksByTitleUseCase searchBooksByTitleUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final BookDtoMapper bookDtoMapper;

    @Autowired
    public BookController(CreateBookUseCase createBookUseCase, GetAllBooksUseCase getAllBooksUseCase, SearchBooksByTitleUseCase searchBooksByTitleUseCase, UpdateBookUseCase updateBookUseCase, DeleteBookUseCase deleteBookUseCase, BookDtoMapper bookDtoMapper) {
        this.createBookUseCase = createBookUseCase;
        this.getAllBooksUseCase = getAllBooksUseCase;
        this.searchBooksByTitleUseCase = searchBooksByTitleUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.bookDtoMapper = bookDtoMapper;
    }

    @PostMapping("/books")
    public String createBook (@RequestBody BookDto bookDto){
        Book book = createBookUseCase.execute(bookDtoMapper.toEntity(bookDto));
        return "Registered book";
    };

    @GetMapping("/books")
    public List<BookDto> getAllBooks(){
        return getAllBooksUseCase.execute().stream()
                .map(bookDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/books/search")
    public List<BookDto> searchByTitle(@RequestParam("title") String title){
        return searchBooksByTitleUseCase.execute(title).stream()
                .map(bookDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/books/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        Book updated = updateBookUseCase.execute(id, bookDtoMapper.toEntity(bookDto));
        return "Updated book";
    }

    @DeleteMapping("books/{id}")
    public String deleteBook(@PathVariable Long id){
        deleteBookUseCase.execute(id);
        return "Deleted book";
    }

}
