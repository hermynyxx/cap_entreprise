package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository  extends
        JpaRepository<Genre, Long> {
}
