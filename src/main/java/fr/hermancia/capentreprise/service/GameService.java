package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.Game;
import fr.hermancia.capentreprise.repository.GameRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameService
        implements
        DAOEntityInterface<Game> {

    private GameRepository gameRepository;



    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Game findBySlug(String slug) {
        Optional<Game> optionalGame = gameRepository.findBySlug(slug);
        if(optionalGame.isEmpty()) {
            throw new RuntimeException("Cet élément n'existe pas.");
        }
        return optionalGame.get();
    }

    public Object findTop9ByOrderByPublishedAtDesc() {
        return gameRepository.findTop9ByOrderByPublishedAtDesc();
    }
}
