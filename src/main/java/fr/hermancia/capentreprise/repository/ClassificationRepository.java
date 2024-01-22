package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository  extends
        JpaRepository<Classification, Long> {
}
