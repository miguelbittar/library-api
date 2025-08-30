package dev.miguelbittar.library_api.infra.persistence;

import dev.miguelbittar.library_api.core.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private String isbn;

    @NotNull
    @Min(0)
    private Integer availableCopies;

    @NotBlank
    private String author;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    private String publisher;

    public BookEntity() {}

    public BookEntity(Long id, String title, String description, String isbn, Integer availableCopies, String author, Category category, String publisher) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
