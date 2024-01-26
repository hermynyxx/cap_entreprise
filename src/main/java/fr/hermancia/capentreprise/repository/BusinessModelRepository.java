package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.BusinessModel;
import fr.hermancia.capentreprise.repository.intefaces.EntityNameRepository;
import fr.hermancia.capentreprise.repository.intefaces.EntitySlugRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessModelRepository
        extends
        JpaRepository<BusinessModel, Long>,
        EntityNameRepository<BusinessModel>,
        EntitySlugRepository<BusinessModel> {
}
