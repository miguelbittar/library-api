package dev.miguelbittar.library_api.infra.presentation;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.usecases.*;
import dev.miguelbittar.library_api.infra.dtos.BookDto;
import dev.miguelbittar.library_api.infra.mapper.BookDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Books", description = "Library book management operations")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final SearchBooksByTitleUseCase searchBooksByTitleUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final BookDtoMapper bookDtoMapper;

    @Autowired
    public BookController(
            CreateBookUseCase createBookUseCase,
            GetAllBooksUseCase getAllBooksUseCase,
            SearchBooksByTitleUseCase searchBooksByTitleUseCase,
            UpdateBookUseCase updateBookUseCase,
            DeleteBookUseCase deleteBookUseCase,
            BookDtoMapper bookDtoMapper) {

        this.createBookUseCase = createBookUseCase;
        this.getAllBooksUseCase = getAllBooksUseCase;
        this.searchBooksByTitleUseCase = searchBooksByTitleUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.bookDtoMapper = bookDtoMapper;
    }

    @PostMapping("/books")
    @Operation(summary = "Register a new book", description = "Creates a new book in the library catalog")
    @ApiResponse(responseCode = "201", description = "Book created successfully")
    @ApiResponse(responseCode = "409", description = "ISBN already exists")
    public ResponseEntity<Map<String, Object>> createBook (@RequestBody BookDto bookDto){
        Book newBook = createBookUseCase.execute(bookDtoMapper.toEntity(bookDto));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book successfully registered in our database");
        response.put("book data", bookDtoMapper.toDto(newBook));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    };

    @GetMapping("/books")
    @Operation(summary = "Get all books", description = "Retrieves a complete list of all books in the library catalog")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> books = getAllBooksUseCase.execute().stream()
                .map(bookDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/search")
    @Operation(summary = "Search books by title", description = "Find books by searching title matches (case-insensitive)")
    @ApiResponse(responseCode = "200", description = "Books found matching the search criteria")
    @ApiResponse(responseCode = "404", description = "No books found")
    public ResponseEntity<List<BookDto>> searchByTitle(@RequestParam("title") String title){
        List<BookDto> books = searchBooksByTitleUseCase.execute(title).stream()
                .map(bookDtoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }

    @PutMapping("/books/{id}")
    @Operation(summary = "Update book information", description = "Updates an existing book's information in the catalog")
    @ApiResponse(responseCode = "200", description = "Book updated successfully")
    @ApiResponse(responseCode = "404", description = "Book not found")
    public ResponseEntity<Map<String, Object>> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        Book updated = updateBookUseCase.execute(id, bookDtoMapper.toEntity(bookDto));
        Map<String, Object> response = new HashMap<>();
        response.put("message","Book successfully updated in our database");
        response.put("book data", bookDtoMapper.toDto(updated));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("books/{id}")
    @Operation(summary = "Delete a book", description = "Removes a book from the library catalog")
    @ApiResponse(responseCode = "200", description = "Book deleted successfully")
    @ApiResponse(responseCode = "404", description = "Book not found")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id){
        deleteBookUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("Message:","Book successfully deleted in our database");
        return ResponseEntity.ok(response);
    }
}
