package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;

public interface UpdateBookUseCase {

    public Book execute(Long id, Book book);
}
