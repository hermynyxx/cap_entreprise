package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends
        JpaRepository<Game, Long> {
}
