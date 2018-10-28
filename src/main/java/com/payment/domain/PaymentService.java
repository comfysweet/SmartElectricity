package com.payment.domain;

import com.redisstore.domain.Record;
import com.redisstore.domain.RecordService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentService {

    private RecordService recordService;

    public PaymentService(RecordService recordService) {
        this.recordService = recordService;
    }

    private Pair<Double, Double> getPayment(Record record) {
        String counterType = record.getCounterType();
        List<String> lastValues = record.getLastValue();
        List<String> currentValues = record.getCurrentValue();

        Double cost = 0.00;
        Double electricity = 0.00;


        if (counterType.equals("1")) {
            electricity = (double) (Integer.valueOf(currentValues.get(0)) - Integer.valueOf(lastValues.get(0)));
            cost = electricity * 4.00;
        }

        if (counterType.equals("2")) {
            Double electricity1 = (double) (Integer.valueOf(currentValues.get(0)) - Integer.valueOf(lastValues.get(0)));
            Double electricity2 = (double) (Integer.valueOf(currentValues.get(1)) - Integer.valueOf(lastValues.get(1)));
            electricity = electricity1 + electricity2;
            cost = electricity1 * 4.31 + electricity2 * 2.12;
        }

        if (counterType.equals("3")) {
            Double electricity1 = (double) (Integer.valueOf(currentValues.get(0)) - Integer.valueOf(lastValues.get(0)));
            Double electricity2 = (double) (Integer.valueOf(currentValues.get(1)) - Integer.valueOf(lastValues.get(1)));
            Double electricity3 = (double) (Integer.valueOf(currentValues.get(2)) - Integer.valueOf(lastValues.get(2)));
            electricity = electricity1 + electricity2 + electricity3;
            cost = electricity1 * 4.33 + electricity2 * 4.00 + electricity3 * 2.12;
        }

        return new Pair<>(cost, electricity);
    }

    public PaymentInformation getPaymentInformation(String paymentPeriod) {
        Record record = recordService.getRecordByPaymentPeriod(paymentPeriod);

        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setPaymentPeriod(paymentPeriod);
        paymentInformation.setCost(getPayment(record).getKey());
        paymentInformation.setElectricity(getPayment(record).getValue());

        return paymentInformation;
    }
}
