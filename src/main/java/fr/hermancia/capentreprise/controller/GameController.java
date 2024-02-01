package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.DTO.ReviewDTO;
import fr.hermancia.capentreprise.entity.Game;
import fr.hermancia.capentreprise.mapping.UrlRoute;
import fr.hermancia.capentreprise.service.GameService;
import fr.hermancia.capentreprise.service.ReviewService;
import fr.hermancia.capentreprise.utils.FlashMessage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GameController {


    private GameService gameService;

    private ReviewService reviewService;

    @GetMapping(UrlRoute.URL_GAME)
    public ModelAndView index(
            ModelAndView mav,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "publishedAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        mav.setViewName("game/index");
        mav.addObject("pageGames", gameService.findAll(pageable));
        return mav;
    }

    @GetMapping(UrlRoute.URL_GAME_SLUG)
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav,
            Principal principal,
            @ModelAttribute("flashMessage") FlashMessage flashMessage,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "createdAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        mav.setViewName("game/show");
        if (principal != null) {
            mav.addObject("reviewDto", new ReviewDTO());
        }
        Game game = gameService.findBySlug(slug);
        mav.addObject("flashMessage", flashMessage);
        mav.addObject("game", game);
        mav.addObject("pageReviews", reviewService.findAllByGame(game, pageable));
        return mav;
    }

    @PostMapping(UrlRoute.URL_GAME_SLUG)
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav,
            Principal principal,
            @ModelAttribute("reviewDto") ReviewDTO reviewDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            mav.setViewName("game/show");
            return mav;
        }
        reviewService.createReview(
                reviewDTO,
                gameService.findBySlug(slug),
                principal.getName()
        );
        redirectAttributes.addFlashAttribute(
                "flashMessage",
                new FlashMessage("success", "Votre commentaire a bien été enregistré, il est actuellement en attente de modération !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAME + "/" + slug);
        return mav;
    }
}

