package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.entity.Moderator;
import fr.hermancia.capentreprise.mapping.UrlRoute;
import fr.hermancia.capentreprise.service.ReviewService;
import fr.hermancia.capentreprise.service.UserService;
import fr.hermancia.capentreprise.utils.FlashMessage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ReviewController {


    private ReviewService reviewService;
    private UserService userService;

    @GetMapping(value = UrlRoute.URL_REVIEW)
    public ModelAndView list(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = {"createdAt"}, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable

    ) {
        {
            if (principal == null) {
                mav.setViewName("redirect:/login");
                return mav;
            }
            mav.setViewName("index");
            mav.addObject("reviewsList", reviewService.findAll(pageable));
            return mav;
        }
    }




    @GetMapping(UrlRoute.URL_REVIEW_MODERATE)
    public ModelAndView moderate(
            @PathVariable Long id,
            @PathVariable Long moderate,
            ModelAndView modelAndView,
            RedirectAttributes redirectAttributes,
            Principal principal
    ) {
        boolean isModerate = reviewService.moderateReview(principal.getName(), id, moderate);
        FlashMessage flashMessage = new FlashMessage("success", "Le commentaire a bien été modéré !");
        if (!isModerate) {
            flashMessage = new FlashMessage("warning", "Le commentaire a bien été supprimé !");
        }
        redirectAttributes.addFlashAttribute("flashMessage", flashMessage);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }


}
