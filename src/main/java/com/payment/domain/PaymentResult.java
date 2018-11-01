package com.payment.domain;

public class PaymentResult {

    private String resultDescription;

    public PaymentResult (String result) {
        this.resultDescription = result;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

}
