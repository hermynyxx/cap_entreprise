package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.DTO.RegistrationUserDTO;
import fr.hermancia.capentreprise.mapping.UrlRoute;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping(value = UrlRoute.URL_HOME)
    public ModelAndView listGame(ModelAndView mav) {
        mav.setViewName("home");

        return mav;
    }
}
