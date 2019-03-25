package com.example.sweater.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PreBetController {
    @GetMapping("/prebet")
    public String Test(){
        return "bet";
    }
}
