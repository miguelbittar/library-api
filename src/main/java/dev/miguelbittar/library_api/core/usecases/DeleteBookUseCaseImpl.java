package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;
import dev.miguelbittar.library_api.core.gateway.BookGateway;
import dev.miguelbittar.library_api.infra.exceptions.BookNotFoundException;

public class DeleteBookUseCaseImpl implements DeleteBookUseCase{

    private final BookGateway bookGateway;

    public DeleteBookUseCaseImpl(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public void execute(Long id){
        Book existing = bookGateway.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookGateway.delete(id);
    }
}
