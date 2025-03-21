package com.clomb.tracker.controller;

import com.clomb.tracker.dto.GymDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Main {

    @GetMapping
    public String hello() {
        return "hello";

    }
}
