package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.DTO.RegistrationUserDTO;
import fr.hermancia.capentreprise.mapping.UrlRoute;
import fr.hermancia.capentreprise.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    private GameService gameService;

    @GetMapping(value = UrlRoute.URL_HOME)
    public ModelAndView listGame(ModelAndView mav,Principal principal) {
        if (principal != null) {
            // get the full object User => userService.findByNickname();
            // if user.isAdmin => redirect to /admin
            // else redirect => ???
        }
        mav.addObject("gamesReleased", gameService.findTop9ByOrderByPublishedAtDesc());
        mav.setViewName("home");

        return mav;
    }
}
