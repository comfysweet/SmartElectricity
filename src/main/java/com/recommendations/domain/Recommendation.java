package com.recommendations.domain;

public class Recommendation {

    // Positive or negative
    private Boolean isPositive;
    // Description of positive/negative recommendation
    private String description;

    public Recommendation(String description, Boolean isPositive) {
        this.isPositive = isPositive;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPositive() {
        return isPositive;
    }

    public void setPositive(Boolean positive) {
        isPositive = positive;
    }
}
