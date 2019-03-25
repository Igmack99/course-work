package com.example.sweater.database.Service;

import com.example.sweater.database.entities.Bet;
import com.example.sweater.database.repos.BetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    @Autowired
    BetRepo betRepo;


    public void doBet(Bet bet) {


        if (bet.getBetamount() > 0)
            betRepo.saveAndFlush(bet);
    }
}
