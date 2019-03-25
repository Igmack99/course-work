package com.example.sweater.controller;


import com.example.sweater.database.Service.AuthorService;
import com.example.sweater.database.Service.PlayerInfoService;
import com.example.sweater.database.entities.Author;
import com.example.sweater.database.entities.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @GetMapping("/authors")

    public List<String> allAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author Author(@PathVariable Author id){
        return id;
    }
}
