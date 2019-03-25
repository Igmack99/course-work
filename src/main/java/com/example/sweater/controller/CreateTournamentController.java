package com.example.sweater.controller;

import com.example.sweater.database.entities.Match;
import com.example.sweater.database.entities.Tournament;
import com.example.sweater.database.repos.PlayerInfoRepo;
import com.example.sweater.database.repos.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class CreateTournamentController {

    @Autowired
    PlayerInfoRepo playerInfoRepo;
    @Autowired
    TournamentRepo tournamentRepo;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public String addTournament(@RequestParam long id,
                                @RequestParam String nameoft,
                                @RequestParam int amountofp,
                                @RequestParam String country
                            ){
        Tournament tournament = new Tournament();
        tournament.setId(id);
        tournament.setNameoft(nameoft);
        tournament.setAmountofp(amountofp);
        tournament.setCountry(country);
        tournamentRepo.saveAndFlush(tournament);
        return "main";
    }
    @GetMapping("/create")
        public String getForm(){
        return "tournament";
        }
}
