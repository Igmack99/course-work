package com.example.sweater.database.Service;

import com.example.sweater.database.entities.Bet;
import com.example.sweater.database.entities.Match;
import com.example.sweater.database.entities.PlayerInfo;
import com.example.sweater.database.entities.Tournament;
import com.example.sweater.database.repos.BetRepo;
import com.example.sweater.database.repos.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Service
public class MatchService {
    @Autowired
    MatchRepo matchRepo;

    @Autowired
    BetRepo betRepo;
    void delete (long id) {
        matchRepo.deleteById(id);
    }

    Match vremya (Date date) { return  matchRepo.findByDate(date);
    }
    Match igrok (PlayerInfo playerInfo) { return  matchRepo.findByPlayerInfo(playerInfo);
    }
    Match turnir (Tournament tournament) { return  matchRepo.findByTournament(tournament);
    }
    Match winner (PlayerInfo winner) { return  matchRepo.findByWinner(winner);
    }

    List<Bet> getAllMatchBets(Long id){
        List<Bet> bets = new LinkedList<Bet>();
        for(Bet bet : betRepo.findAll()){
            if(bet.getMatch().getId()==id)
                bets.add(bet);
        }

        return bets;
    }

    void editMatch(Long id, Integer event1){
        Match match = matchRepo.getOne(id);
        match.setEvent1(event1);
        matchRepo.saveAndFlush(match);
    }
    void editMatch1(Long id, Integer event2){
        Match match = matchRepo.getOne(id);
        match.setEvent2(event2);
        matchRepo.saveAndFlush(match);
    }
    void editMatch2(Long id, Date date){
        Match match = matchRepo.getOne(id);
        match.setDate(date);
        matchRepo.saveAndFlush(match);
    }


}
