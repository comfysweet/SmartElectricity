package com.redisstore.controller;

import com.redisstore.domain.Record;
import com.redisstore.domain.RecordService;
import com.redisstore.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/redis")
public class WebController {

    private RecordService recordService;

    @Autowired
    private RedisRepository redisRepository;

    public WebController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping(value = "/add")
    public @ResponseBody
    ResponseEntity<String> getRecords(){
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
        return redisRepository.findAllMovies();
    }

    @RequestMapping("/values")
    public @ResponseBody
    Map<String, String> findAll() {
        Map<Object, Object> aa = redisRepository.findAllMovies();
        Map<String, String> map = new HashMap<String, String>();
        for (Map.Entry<Object, Object> entry : aa.entrySet()) {
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(
            @RequestParam String key,
            @RequestParam String value) {

        Record record = new Record(key, value);

        redisRepository.add(record);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestParam String key) {
        redisRepository.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
