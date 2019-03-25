package com.example.sweater.controller;


import com.example.sweater.database.entities.Bet;
import com.example.sweater.database.entities.Users;
import com.example.sweater.database.repos.BetRepo;
import com.example.sweater.database.repos.MatchRepo;
import com.example.sweater.database.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
public class BetController {
    @Autowired
    BetRepo betRepo;
    @Autowired
    MatchRepo matchRepo;
    @Autowired
    UsersRepo usersRepo;
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping ("/bet")
    public List<Bet> allBet() {
        return betRepo.findAll();
    }

    @PreAuthorize("user.id == authUser.id")
    @GetMapping ("/bet/{user}")
    public List<Bet> allBet(@PathVariable Users user,
                            @AuthenticationPrincipal Users authUser) {
        List<Bet> bets = betRepo.findAll();
        List<Bet> userBets = new ArrayList<>();
        for(Bet bet  : bets){
            if(bet.getUsers().getId() == user.getId())
                userBets.add(bet);
            }
            return userBets;
    }

    @PostMapping("/bet")
    public List<Bet> makeBet(
           long id,
         int coef,
        String eventname,
        long match_id,
        long users_id,
          int betamount
    ) {
        Bet bet = new Bet();
        bet.setId(id);
        bet.setCoef(coef);
        bet.setEventname(eventname);
     //   bet.setUsers(usersRepo.getOne(users_id));  bet.setMatch(matchRepo.getOne(match_id));

        bet.setBetamount(betamount);
        betRepo.saveAndFlush(bet);
        List<Bet> bets = betRepo.findAll();
        System.out.println(bets.size());
        return bets;

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/bet/delete")
    public List<Bet> deleteBet(@RequestParam long id){
        betRepo.deleteById(id);
        return betRepo.findAll();
    }

}
