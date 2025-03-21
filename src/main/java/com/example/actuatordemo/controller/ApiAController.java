package com.example.actuatordemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiAController {

    @GetMapping("/api/b/data")
    public String provideData() {
        return "Data from API B";
    }
}
