package com.redisstore.domain;

import com.redisstore.repository.RecordRedisRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RecordService {

    private ArrayList<Record> records;

    public RecordRedisRepositoryImpl redisRepository;

    public RecordService(RecordRedisRepositoryImpl redisRepository) {
        this.redisRepository = redisRepository;
        createMock();
    }

    private void createMock() {
        records = new ArrayList<>();

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("1110");
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("1150");

        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("1150");
        arrayList3.add("1210");
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("1160");
        arrayList4.add("1250");

        ArrayList<String> arrayList5 = new ArrayList<>();
        arrayList5.add("1250");
        arrayList5.add("1310");
        arrayList5.add("1010");
        ArrayList<String> arrayList6 = new ArrayList<>();
        arrayList6.add("1300");
        arrayList6.add("1360");
        arrayList6.add("1115");

        records.add(new Record("01.2018", "1", arrayList1, arrayList2));
        records.add(new Record("02.2018", "2", arrayList3, arrayList4));
        records.add(new Record("04.2018", "3", arrayList5, arrayList6));

//        records.add(new Record("01.2018", "1", "11", "22"));
//        records.add(new Record("02.2018", "2", "33", "44"));
//        records.add(new Record("03.2018", "3", "55", "66"));
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public Record getRecordByPaymentPeriod(String paymentPeriod) {
        return redisRepository.findRecord(paymentPeriod);
    }
}
