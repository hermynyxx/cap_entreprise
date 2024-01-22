package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeratorRepository  extends
        JpaRepository<Moderator, Long> {
}
