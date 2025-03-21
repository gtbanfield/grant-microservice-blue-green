package com.example.actuatordemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiAService {

    @Autowired
    private com.example.actuatordemo.service.ApiAService apiAService;

    @GetMapping("/api/a/request")
    public String requestToApiB() {
        return apiAService.getDataFromApiB();
    }
}

