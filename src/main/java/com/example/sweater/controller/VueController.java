package com.example.sweater.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VueController {
    @GetMapping("/vue")
    public String vue(){
        return "vueTest";
    }
}
