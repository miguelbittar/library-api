package dev.miguelbittar.library_api.infra.presentation;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.usecases.*;
import dev.miguelbittar.library_api.infra.dtos.BookDto;
import dev.miguelbittar.library_api.infra.mapper.BookDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Map<String, Object>> createBook (@RequestBody BookDto bookDto){
        Book newBook = createBookUseCase.execute(bookDtoMapper.toEntity(bookDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message:", "Book successfully registered in our database");
        response.put("Book data:", bookDtoMapper.toDto(newBook));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    };

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> books = getAllBooksUseCase.execute().stream()
                .map(bookDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/search")
    public ResponseEntity<List<BookDto>> searchByTitle(@RequestParam("title") String title){
        List<BookDto> books = searchBooksByTitleUseCase.execute(title).stream()
                .map(bookDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Map<String, Object>> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        Book updated = updateBookUseCase.execute(id, bookDtoMapper.toEntity(bookDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message:","Book successfully updated in our database");
        response.put("Book data:", bookDtoMapper.toDto(updated));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id){
        deleteBookUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("Message:","Book successfully deleted in our database");
        return ResponseEntity.ok(response);
    }
}
