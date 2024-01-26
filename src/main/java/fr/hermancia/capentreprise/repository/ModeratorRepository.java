package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Moderator;
import fr.hermancia.capentreprise.repository.intefaces.EntityNameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository
        extends
        JpaRepository<Moderator, Long> {
}
