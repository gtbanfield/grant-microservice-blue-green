package com.example.actuatordemo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "blue")
public class CustomEndpoint {

    @ReadOperation
    public String customEndpoint() {
<<<<<<< HEAD
        return "Hi Grant, this is Blue endpoint!";
=======
        return "Hi Grant, this is Green 2 endpoint!";
>>>>>>> a909036 (test)
    }
}
