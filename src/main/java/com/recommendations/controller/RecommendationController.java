package com.recommendations.controller;

import com.recommendations.domain.Recommendation;
import com.recommendations.domain.RecommendationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recommendation")
public class RecommendationController {

    private RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public @ResponseBody Recommendation getRecommendation(){
        return recommendationService.getRecommendation();
    }

}
