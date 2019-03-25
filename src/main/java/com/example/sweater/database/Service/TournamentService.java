package com.example.sweater.database.Service;

import com.example.sweater.database.entities.News;
import com.example.sweater.database.entities.PlayerInfo;
import com.example.sweater.database.entities.Tournament;
import com.example.sweater.database.repos.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {
    @Autowired
    TournamentRepo tournamentRepo;
    void delete (long id) {
        tournamentRepo.deleteById(id);
    }

    Tournament detected (String nameoft) {
        return  tournamentRepo.findByNameoft(nameoft);
    }

    Tournament  PoIPvychysly (String country) { return  tournamentRepo.findByCountry(country);
    }

    void editTournament(Long id, String nameoft) {
        Tournament tournament = tournamentRepo.getOne(id);
        tournament.setNameoft(nameoft);
        tournamentRepo.saveAndFlush(tournament);
    }
    void editTournament1(Long id, String nameofp) {
        Tournament tournament = tournamentRepo.getOne(id);
        tournament.setNameoft(nameofp);
        tournamentRepo.saveAndFlush(tournament);
    }
    void editTournament2(Long id, String country) {
        Tournament tournament = tournamentRepo.getOne(id);
        tournament.setNameoft(country);
        tournamentRepo.saveAndFlush(tournament);
    }
    void editTournament3(Long id, Integer amountofp){
        Tournament tournament = tournamentRepo.getOne(id);
        tournament.setAmountofp(amountofp);
        tournamentRepo.saveAndFlush(tournament);
    }

    public List<String> getTournaments(){
        List<String> nameofts = new ArrayList<>();
        List<Tournament> tournaments = tournamentRepo.findAll();
        for(Tournament myT : tournaments){
            nameofts.add(myT.getNameoft());
        }
        return nameofts;

    }
}
