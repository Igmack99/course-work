package com.example.sweater.controller;

import com.example.sweater.database.entities.News;
import com.example.sweater.database.entities.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.sweater.database.repos.TournamentRepo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.sweater.database.Service.TournamentService;

import java.util.List;

@RestController
public class TournamentController {
    @Autowired
    TournamentRepo tournamentRepo;
    @Autowired
    TournamentService tournamentService;
    @GetMapping("/tournaments")
    public List<String> allTournaments() {
        return tournamentService.getTournaments();
    }
    @GetMapping("/tournaments/{id}")
    public Tournament Tournaments(@PathVariable Tournament id){
        return id;
    }
}
