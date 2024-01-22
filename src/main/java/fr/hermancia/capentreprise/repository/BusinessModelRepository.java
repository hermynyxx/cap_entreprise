package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.BusinessModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessModelRepository  extends
        JpaRepository<BusinessModel, Long> {
}
