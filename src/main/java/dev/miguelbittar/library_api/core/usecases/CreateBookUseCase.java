package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;

public interface CreateBookUseCase {

    public Book execute(Book book);
}
