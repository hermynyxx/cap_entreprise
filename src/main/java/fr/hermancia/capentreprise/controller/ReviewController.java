package fr.hermancia.capentreprise.controller;

import fr.hermancia.capentreprise.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ReviewControlller {

    private ReviewService reviewService;

    @GetMapping("/review_list")
    public ModelAndView list(ModelAndView mav) {
        mav.setViewName("review");
        mav.addObject("reviews", reviewService.findTop15ByOrderByCreatedAtDesc());
        return mav;
    }
}
