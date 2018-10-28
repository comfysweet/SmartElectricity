package com.redisstore.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RecordService {

    private ArrayList<Record> records;

    public RecordService() {
        records = new ArrayList<>();
        records.add(new Record("1", "2018", "01", "1", "1110", "1150"));
        records.add(new Record("2", "2018", "02", "2", "1150", "1170"));
        records.add(new Record("3", "2018", "03", "3", "1170", "1200"));
        records.add(new Record("4", "2018", "04", "1", "1200", "1250"));
    }

    public ArrayList<Record> getRecords() {
        return records;
    }
}
