package com.redisstore.controller;

import com.redisstore.domain.Record;
import com.redisstore.domain.RecordService;
import com.redisstore.repository.RecordRedisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/redis")
public class RecordController {

    private RecordService recordService;


    private RecordRedisRepository recordRedisRepository;

    public RecordController(RecordService recordService, RecordRedisRepository recordRedisRepository) {
        this.recordService = recordService;
        this.recordRedisRepository = recordRedisRepository;
    }

    @PostMapping(value = "/mockRecords")
    public @ResponseBody
    ResponseEntity<String> getRecords() {
        recordRedisRepository.add(recordService.getRecords());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping
    public String Record() {
        return "Record";
    }

    @RequestMapping("/keys")
    public @ResponseBody
    Map<Object, Object> keys() {
        return recordRedisRepository.findAllRecords();
    }

    @RequestMapping("/values")
    public @ResponseBody
    Map<String, String> findAll() {
        Map<Object, Object> aa = recordRedisRepository.findAllRecords();
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : aa.entrySet()) {
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }

    @PostMapping
    public ResponseEntity<String> add(
            @RequestParam String paymentPeriod,
            @RequestParam String kindCounter,
            @RequestParam ArrayList<String> lastValue,
            @RequestParam ArrayList<String> currentValue
    ) {

        Record record = new Record(paymentPeriod, kindCounter, lastValue, currentValue);

        recordRedisRepository.add(record);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<String> delete(@PathVariable("key") String key) {
        recordRedisRepository.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
