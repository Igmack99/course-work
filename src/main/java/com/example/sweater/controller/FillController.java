package com.example.sweater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FillController {
    @GetMapping("/form")
    public String Formochka(){
        return "match";
    }

}
