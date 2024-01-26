package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.mapping.UrlRoute;
import fr.hermancia.capentreprise.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ReviewController {


    private ReviewService reviewService;

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
}
