package com.recommendations.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RecommendationService {

    private ArrayList<Recommendation> recommendations;


    public RecommendationService() {
        recommendations = new ArrayList<>();
        recommendations.add(new Recommendation("Ты очень экономный, так держать!", "true"));
        recommendations.add(new Recommendation("Стираешь вещи у родителей? хитро!", "true"));
        recommendations.add(new Recommendation("Кажется, я знаю, кто заряжает телефон на работе", "false"));
        recommendations.add(new Recommendation("Ты потратил на электричество больше, чем в прошлом месяце", "false"));
        recommendations.add(new Recommendation("Майнишь крипту? С таким курсом ты потратишь больше, чем заработаешь", "false"));
    }

    public ArrayList<Recommendation> getRecommendation() {
        ArrayList<Recommendation> recommendationArrayList = new ArrayList<>();
        recommendationArrayList.add(recommendations.get(ThreadLocalRandom.current().nextInt(0, recommendations.size() - 1)));
        recommendationArrayList.add(recommendations.get(ThreadLocalRandom.current().nextInt(0, recommendations.size() - 1)));
//        return recommendations.get(ThreadLocalRandom.current().nextInt(0, recommendations.size() - 1));

        return recommendationArrayList;
    }

}
