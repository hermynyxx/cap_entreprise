package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.Game;
import fr.hermancia.capentreprise.repository.GameRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
