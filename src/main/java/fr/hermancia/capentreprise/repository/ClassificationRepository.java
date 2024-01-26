package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Classification;
import fr.hermancia.capentreprise.repository.intefaces.EntityNameRepository;
import fr.hermancia.capentreprise.repository.intefaces.EntitySlugRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository
        extends
        JpaRepository<Classification, Long>,
        EntityNameRepository<Classification>,
        EntitySlugRepository<Classification> {
}
