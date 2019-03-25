package com.example.sweater.controller;

import com.example.sweater.database.Service.PlayerInfoService;
import com.example.sweater.database.entities.News;
import com.example.sweater.database.entities.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerInfoController {
    @Autowired
    PlayerInfoService playerInfoService;
    @GetMapping("/players")
    public List<String> allPlayers() {
        return playerInfoService.getPlayers();
    }
    @GetMapping("/players/{id}")
    public PlayerInfo Player(@PathVariable PlayerInfo id){
        return id;
    }
}
