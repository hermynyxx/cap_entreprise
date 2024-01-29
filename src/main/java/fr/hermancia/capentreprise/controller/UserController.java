package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.DTO.RegistrationUserDTO;
import fr.hermancia.capentreprise.entity.User;
import fr.hermancia.capentreprise.mapping.UrlRoute;
import fr.hermancia.capentreprise.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;



    @GetMapping(UrlRoute.URL_USER + "/{nickname}")
    public ModelAndView profile(
            ModelAndView mav,
            @PathVariable String nickname,
            HttpServletRequest request
    ) {
        User user = userService.findByNickname(nickname);
        return getViewProfileByUser(mav, request, user);
    }

    @PostMapping(UrlRoute.URL_USER + "/{nickname}")
    public ModelAndView profile(
            ModelAndView mav,
            @PathVariable String name,
            HttpServletRequest request,
            @ModelAttribute("userPutDto") RegistrationUserDTO userPutDTO
    ) {
        User user = userService.edit(name, userPutDTO);
        return getViewProfileByUser(mav, request, user);
    }

    private ModelAndView getViewProfileByUser(
            ModelAndView mav,
            HttpServletRequest request,
            User user
    ) {
        mav.setViewName("user/profile");
        mav.addObject("userPutDto", userService.getUserPutDTOByUser(user));
        mav.addObject("user", user);
        mav.addObject("uri", request.getRequestURI());
        return mav;
    }

}

