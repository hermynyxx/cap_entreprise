package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.DTO.GameDTO;
import fr.hermancia.capentreprise.entity.Game;
import fr.hermancia.capentreprise.entity.Moderator;
import fr.hermancia.capentreprise.repository.GameRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameService
        implements
        DAOEntityInterface<Game> {

    private GameRepository gameRepository;

    private UserService userService;



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

    public Game create(GameDTO gameDTO, String nickname) {
        Game game = new Game();
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setPublishedAt(LocalDate.parse(gameDTO.getPublishedAt()));
        game.setGenre(gameDTO.getGenre());
        game.setBusinessModel(gameDTO.getBusinessModel());
        game.setPublisher(gameDTO.getPublisher());
        game.setClassification(gameDTO.getClassification());
        game.setPlatforms(gameDTO.getPlatforms());
        game.setModerator((Moderator) userService.findByNickname(nickname));
        game.setImage("https://static.vecteezy.com/system/resources/previews/005/337/799/original/icon-image-not-found-free-vector.jpg");
        return gameRepository.saveAndFlush(game);
    }

    public void saveImageToGame(String fileName, String slug) {
        Game game = findBySlug(slug);
        game.setImage(fileName);
        gameRepository.flush();
    }



    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }




    public Object findTop9ByOrderByPublishedAtDesc() {
        return gameRepository.findTop9ByOrderByPublishedAtDesc();
    }
}
