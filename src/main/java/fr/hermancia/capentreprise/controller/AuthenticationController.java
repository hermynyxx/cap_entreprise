package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.DTO.RegistrationUserDTO;
import fr.hermancia.capentreprise.mapping.UrlRoute;
import fr.hermancia.capentreprise.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class AuthenticationController {

    private UserService userService;

    @GetMapping(value = UrlRoute.URL_REGISTER)
    public ModelAndView register(ModelAndView mav) {
        mav.setViewName("security/register");
        mav.addObject("userForm", new RegistrationUserDTO());
        return mav;
    }

    @PostMapping(value = UrlRoute.URL_REGISTER)
    public ModelAndView register(
            @Valid @ModelAttribute("userForm") RegistrationUserDTO userForm,
            BindingResult bindingResult,
            ModelAndView mav
    ) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("security/register");
            return mav;
        }
        userService.create(userForm);
        mav.setViewName("redirect:" + UrlRoute.URL_HOME);
        return mav;
    }

    @GetMapping("/")
    public ModelAndView index(
            ModelAndView mav,
            Principal principal
    ) {
        if (principal == null) {
            mav.setViewName("redirect:/login");
            return mav;
        }
        mav.setViewName("redirect:/home");
        return mav;
    }



    @GetMapping(value = UrlRoute.URL_LOGIN)
    public ModelAndView login(
            ModelAndView mav,
            String error
    ){
        if (error != null){
            mav.addObject("error", "Your username or password is invalid.");
        }
        mav.setViewName("security/login");
        return mav;
    }
}
