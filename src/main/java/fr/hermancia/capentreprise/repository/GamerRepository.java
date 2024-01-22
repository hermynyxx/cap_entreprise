package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository  extends
        JpaRepository<Gamer, Long> {
}
