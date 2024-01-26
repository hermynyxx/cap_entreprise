package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Genre;
import fr.hermancia.capentreprise.repository.intefaces.EntityNameRepository;
import fr.hermancia.capentreprise.repository.intefaces.EntitySlugRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository
        extends
        JpaRepository<Genre, Long>,
        EntityNameRepository<Genre>,
        EntitySlugRepository<Genre> {
}
