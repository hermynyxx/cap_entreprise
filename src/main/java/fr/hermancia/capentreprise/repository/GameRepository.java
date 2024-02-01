package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Game;
import fr.hermancia.capentreprise.entity.Review;
import fr.hermancia.capentreprise.repository.intefaces.EntityNameRepository;
import fr.hermancia.capentreprise.repository.intefaces.EntitySlugRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository
        extends
        JpaRepository<Game, Long>,
        EntityNameRepository<Game>,
        EntitySlugRepository<Game> {
    List<Game> findTop9ByOrderByPublishedAtDesc();

    Page<Game> findAll(Pageable pageable);
}
