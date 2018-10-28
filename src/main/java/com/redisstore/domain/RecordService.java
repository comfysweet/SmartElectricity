package com.redisstore.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RecordService {

    private ArrayList<Record> records;

    public RecordService() {
        records = new ArrayList<>();
        records.add(new Record("1", "222"));
        records.add(new Record("2", "333"));
        records.add(new Record("3", "444"));
        records.add(new Record("4", "555"));
        records.add(new Record("5", "666"));
        records.add(new Record("6", "777"));
    }

    public ArrayList<Record> getRecords() {
        return records;
    }
}
