package com.example.sweater.controller;

import com.example.sweater.database.Service.MatchService;
import com.example.sweater.database.entities.Match;
import com.example.sweater.database.entities.News;
import com.example.sweater.database.repos.MatchRepo;
import com.example.sweater.database.repos.PlayerInfoRepo;
import com.example.sweater.database.repos.TournamentRepo;
import com.example.sweater.database.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MatchController {
    @Autowired
    PlayerInfoRepo playerInfoRepo;
    @Autowired
    TournamentRepo tournamentRepo;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    MatchRepo matchRepo;
    @Autowired
    MatchService matchService;
    @GetMapping("/match/{id}")
    public @ResponseBody  Match Matches(@PathVariable Match id){
        return id;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/match")
    public String matchSchedule(Model model){
        List<Match> matchList = matchRepo.findAll();
        model.addAttribute("matches", matchList);
        return "match";

    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/match")
    public String addMatch(@RequestParam long id, @RequestParam String date, @RequestParam int event1, @RequestParam int event2,
    long player_info_id,  long player_info1_id,
                          long tournament_id, long winner_id){
        Match match = new Match();
        match.setId(id);
        Date date1 = null;
        try {
           date1  =new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        match.setDate(date1);
        match.setEvent2(event2);
        match.setEvent1(event1);
        match.setPlayerInfo(playerInfoRepo.getOne(player_info_id));
        match.setPlayerInfo1(playerInfoRepo.getOne(player_info1_id));
        match.setTournament(tournamentRepo.getOne(tournament_id));
        match.setWinner(playerInfoRepo.getOne(winner_id));
        matchRepo.saveAndFlush(match);
        return "match";
    }

}
