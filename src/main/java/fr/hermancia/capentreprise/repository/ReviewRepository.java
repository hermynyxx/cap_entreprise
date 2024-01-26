package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository  extends
        JpaRepository<Review, Long> {

}
