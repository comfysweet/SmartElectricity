package com.redisstore.controller;

import com.redisstore.domain.Record;
import com.redisstore.domain.RecordService;
import com.redisstore.repository.RedisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/redis")
public class WebController {

    private RecordService recordService;


    private RedisRepository redisRepository;

    public WebController(RecordService recordService, RedisRepository redisRepository) {
        this.recordService = recordService;
        this.redisRepository = redisRepository;
    }

    @PostMapping(value = "/mockRecords")
    public @ResponseBody
    ResponseEntity<String> getRecords() {
        redisRepository.add(recordService.getRecords());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("/keys")
    public @ResponseBody
    Map<Object, Object> keys() {
        return redisRepository.findAllRecords();
    }

    @RequestMapping("/values")
    public @ResponseBody
    Map<String, String> findAll() {
        Map<Object, Object> aa = redisRepository.findAllRecords();
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : aa.entrySet()) {
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(
            @RequestParam String paymentPeriod,
            @RequestParam String kindCounter,
            @RequestParam ArrayList<String> lastValue,
            @RequestParam ArrayList<String> currentValue
    ) {

        Record record = new Record(paymentPeriod, kindCounter, lastValue, currentValue);

        redisRepository.add(record);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String key) {
        redisRepository.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
