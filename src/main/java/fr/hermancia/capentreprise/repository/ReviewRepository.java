package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository  extends
        JpaRepository<Review, Long> {
}
