package com.example.actuatordemo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class SampleController {

    @GetMapping("/")
    public String sayHello(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Hello " + name + "!!";
    }


    @GetMapping("/slowApi")
    public String timeConsumingAPI(@RequestParam(value = "delay", defaultValue = "0") Integer delay) throws InterruptedException {
        if(delay == 0) {
            Random random = new Random();
            delay = random.nextInt(10);
        }

        TimeUnit.SECONDS.sleep(delay);
        return "Result";
    }

    @GetMapping(path = "test", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> headersDemo(@RequestHeader(name = "x-lbg-header") String header) {
        System.out.println("x-lbg-header : " + header);
        String response = "x-lbg-header:" + header;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping("/api1")
    public class Api1Controller {

        private final RestTemplate restTemplate;

        public Api1Controller(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @PostMapping("/send")
        public ResponseEntity<String> sendData(@RequestBody Map<String, Object> data) {
            String api2Url = "http://localhost:8081/api2/receive"; // API 2's endpoint

            ResponseEntity<String> response = restTemplate.postForEntity(api2Url, data, String.class);

            return ResponseEntity.ok("Data sent to API 2, response: " + response.getBody());
        }
    }
    @Configuration
    public class RestTemplateConfig {

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

}
