package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository  extends
        JpaRepository<Publisher, Long> {
}
