package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.DTO.ReviewDTO;
import fr.hermancia.capentreprise.entity.Game;
import fr.hermancia.capentreprise.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/game", name = "AppGame")
public class GameController {

    private GameService gameService;

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(@PathVariable String slug, ModelAndView mav) {
        Game game = gameService.findBySlug(slug);
        // Initialisation du ReviewDTO
        ReviewDTO dto = new ReviewDTO();
        dto.setGameId(game.getId());
        dto.setUserId(1L);
        mav.setViewName("game/show");
        mav.addObject("game", game);
        mav.addObject("reviewDto", dto);
        return mav;
    }
}
