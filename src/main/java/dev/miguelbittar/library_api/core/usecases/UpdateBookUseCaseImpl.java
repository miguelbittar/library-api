package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;

public class UpdateBookUseCaseImpl implements UpdateBookUseCase{

    private final BookGateway bookGateway;

    public UpdateBookUseCaseImpl(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public Book execute(Long id, Book book){
        Book existing = bookGateway.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with ID " + id + " not found"));
        Book updated = withUpdatedFields(existing, book);

        return bookGateway.save(updated);
    }

    private Book withUpdatedFields(Book existing, Book newValues) {
        return new Book(
                existing.id(),
                newValues.title() != null ? newValues.title() : existing.title(),
                newValues.description() != null ? newValues.description() : existing.description(),
                newValues.isbn() != null ? newValues.isbn() : existing.isbn(),
                newValues.availableCopies() != null ? newValues.availableCopies() : existing.availableCopies(),
                newValues.author() != null ? newValues.author() : existing.author(),
                newValues.category() != null ? newValues.category() : existing.category(),
                newValues.publisher() != null ? newValues.publisher() : existing.publisher()
        );
    }
}
