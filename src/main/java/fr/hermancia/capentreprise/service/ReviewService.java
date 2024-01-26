package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.Publisher;
import fr.hermancia.capentreprise.entity.Review;
import fr.hermancia.capentreprise.repository.ReviewRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ReviewService
        implements
        DAOEntityInterface<Review> {

    private ReviewRepository reviewRepository;


    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }
}
