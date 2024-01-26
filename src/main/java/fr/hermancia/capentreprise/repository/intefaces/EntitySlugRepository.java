package fr.hermancia.capentreprise.repository.intefaces;

import java.util.Optional;

public interface EntitySlugRepository<T>{

    Optional<T> findBySlug(String slug);
}
