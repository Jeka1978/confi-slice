package com.slice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Evegeny on 24/09/2016.
 */
@RestController
public class PingController {
    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }
}
