package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Game;
import fr.hermancia.capentreprise.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository  extends
        JpaRepository<Review, Long> {

    Page<Review> findAllByGameAndModeratorIsNotNull(Game game, Pageable pageable);



    Page<Review> findByModeratorIsNotNull(Pageable pageable);

    Page<Review> findByModeratorIsNull(Pageable pageable);

    Page<Review> findAllByGame(Game game, Pageable pageable);

    Page<Review> findByModeratorIsNotNullOrGamerNickname(String nickname, Pageable pageable);

    Page<Review> findAllByGamerNickname(String nickname, Pageable pageable);

    Page<Review> findByModeratorIsNotNullAndGamerNickname(String nickname, Pageable pageable);
}

