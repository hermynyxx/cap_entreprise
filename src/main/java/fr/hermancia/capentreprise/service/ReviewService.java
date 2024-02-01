package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.DTO.ReviewDTO;
import fr.hermancia.capentreprise.entity.*;
import fr.hermancia.capentreprise.repository.GameRepository;
import fr.hermancia.capentreprise.repository.ReviewRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewService
        implements
        DAOEntityInterface<Review> {

    private ReviewRepository reviewRepository;
    private GameRepository gameRepository;
    private UserService userService;


    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }


    public Page<Review> findAllByGame(Game game, Pageable pageable) {
        return reviewRepository.findAllByGameAndModeratorIsNotNull(game, pageable);
    }

    public Review createReview(ReviewDTO reviewDTO, Game game, String nickname) {
        Review review = new Review();
        review.setGame(game);
        review.setGamer((Gamer) userService.findByNickname(nickname));
        review.setDescription(reviewDTO.getDescription ());
        review.setRating(reviewDTO.getRating());
        return reviewRepository.saveAndFlush(review);
    }
    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public boolean moderateReview(String nickname, Long id, Long status) {
        Review review = findById(id);
        boolean isModerate = true;
        if (status == 1L) {
            review.setModerator((Moderator) userService.findByNickname(nickname));
            review.setModerationDate(LocalDateTime.now());
        } else {
            reviewRepository.delete(review);
            isModerate = false;
        }
        reviewRepository.flush();
        return isModerate;
    }




    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public Page<Review> getPageReviewByNickname(String nickname, Pageable pageable) {
        User user = userService.findByNickname(nickname);
        Page<Review> pageReviews = findByUserNickname(nickname, pageable);
        if (user.isModerator()) {
            Sort sort = pageable.getSort();
            pageReviews = findAll(pageable);
        }
        return pageReviews;
    }

    public Page<Review> findByUserNickname(String nickname, Pageable pageable) {
        return reviewRepository.findByModeratorIsNotNullOrGamerNickname(nickname, pageable);
    }

    public Page<Review> findReviewsForProfile(
            User user,
            Principal principal,
            Pageable pageable
    ) {
        if (user.getNickname().equals(principal.getName())) {
            return reviewRepository.findAllByGamerNickname(user.getNickname(), pageable);
        }
        return reviewRepository.findByModeratorIsNotNullAndGamerNickname(user.getNickname(), pageable);
    }
}
