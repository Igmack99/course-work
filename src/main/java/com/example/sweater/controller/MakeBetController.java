package com.example.sweater.controller;

import com.example.sweater.database.entities.Bet;
import com.example.sweater.database.entities.BetHistory;
import com.example.sweater.database.entities.Match;
import com.example.sweater.database.entities.Users;
import com.example.sweater.database.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@Controller
public class MakeBetController {

    @Autowired
    UsersRepo usersRepo;
    @Autowired
    MatchRepo matchRepo;
    @Autowired
    BetRepo betRepo;
    @Autowired
    TournamentRepo tournamentRepo;
    @Autowired
    BetHistoryRepo betHistoryRepo;

    @PostMapping("/makebet")
    public String makeBet(Model model,
                          @AuthenticationPrincipal Users user,
                        @RequestParam String selected,
                          @RequestParam int mybet,
                          @RequestParam long tournamentId,
                          @RequestParam long matchId
                       ){

        int coef = Integer.parseInt(selected);
        if(user.getUserbalance() > mybet) {

            double chance = Math.random() * 100;
            if (chance > 50) {
                user.setUserbalance(user.getUserbalance()+ mybet*coef);
        }
        else{
                user.setUserbalance(user.getUserbalance()-mybet);
            }
            usersRepo.saveAndFlush(user);
            Bet bet = new Bet();
            bet.setCoef(coef);
            bet.setEventname(tournamentRepo.getOne(tournamentId).getNameoft());
            bet.setMatch(matchRepo.getOne(matchId));
            bet.setUsers(user);
            bet.setBetamount(mybet);
            betRepo.saveAndFlush(bet);
            BetHistory betHistory = new BetHistory();
            betHistory.setDate(new Date());
            if(chance > 50)
            betHistory.setIssuccess(true);
            else betHistory.setIssuccess(false);
            betHistory.setBet(bet);
            betHistory.setUsers(user);
            betHistoryRepo.saveAndFlush(betHistory);
            System.out.println(selected);
        }

        return "main";

    }

    @GetMapping("/makebet")
    public String getMakeBet(Model model){
        model.addAttribute("matches", matchRepo.findAll()) ;
        return "postBet";
    }
}
