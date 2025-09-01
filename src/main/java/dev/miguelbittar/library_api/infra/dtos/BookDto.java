package dev.miguelbittar.library_api.infra.dtos;

import dev.miguelbittar.library_api.core.enums.Category;

public record BookDto(Long id,
                      String title,
                      String description,
                      String isbn,
                      Integer availableCopies,
                      String author,
                      Category category,
                      String publisher) {
}
