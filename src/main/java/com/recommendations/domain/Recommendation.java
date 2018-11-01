package com.recommendations.domain;

public class Recommendation {

    // Positive or negative
    private String isPositive;
    // Description of positive/negative recommendation
    private String description;

    public Recommendation(String description, String isPositive) {
        this.isPositive = isPositive;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPositive() {
        return isPositive;
    }

    public void setPositive(String positive) {
        isPositive = positive;
    }
}
