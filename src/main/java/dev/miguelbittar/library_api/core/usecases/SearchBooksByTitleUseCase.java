package dev.miguelbittar.library_api.core.usecases;

import dev.miguelbittar.library_api.core.entities.Book;

import java.util.List;

public interface SearchBooksByTitleUseCase {

    public List<Book> execute(String title);
}
