package dev.miguelbittar.library_api.core.entities;

import dev.miguelbittar.library_api.core.enums.Category;

public record Book (Long id,
                    String title,
                    String description,
                    String isbn,
                    Integer availableCopies,
                    String author,
                    Category category,
                    String publisher
                    ){}
