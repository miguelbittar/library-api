package dev.miguelbittar.library_api.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    public List<BookEntity> findByTitleContainingIgnoreCase(String title);
}
