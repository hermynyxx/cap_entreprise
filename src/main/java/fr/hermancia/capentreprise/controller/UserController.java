package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.DTO.RegistrationUserDTO;
import fr.hermancia.capentreprise.entity.User;
import fr.hermancia.capentreprise.mapping.UrlRoute;
import fr.hermancia.capentreprise.service.ReviewService;
import fr.hermancia.capentreprise.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private ReviewService reviewService;

    @GetMapping(UrlRoute.URL_USER + "/{username}")
    public ModelAndView profile(
            ModelAndView mav,
            @PathVariable String username,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "createdAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable,
            Principal principal
    ) {
        User user = userService.findByNickname(username);
        return getViewProfileByUser(mav, user, principal, pageable);
    }

    @PostMapping(UrlRoute.URL_USER + "/{username}")
    public ModelAndView profile(
            ModelAndView mav,
            @PathVariable String username,
            @ModelAttribute("userPutDto") RegistrationUserDTO userPutDTO,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "createdAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable,
            Principal principal
    ) {
        User user = userService.edit(username, userPutDTO);
        return getViewProfileByUser(mav, user, principal, pageable);
    }

    private ModelAndView getViewProfileByUser(
            ModelAndView mav,
            User user,
            Principal principal,
            Pageable pageable
    ) {
        mav.setViewName("user/profile");
        mav.addObject("userPutDto", userService.getUserPutDTOByUser(user));
        mav.addObject("pageReviews", reviewService.findReviewsForProfile(user, principal, pageable));
        mav.addObject("user", user);
        return mav;
    }

}

