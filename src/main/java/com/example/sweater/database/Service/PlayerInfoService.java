package com.example.sweater.database.Service;

import com.example.sweater.database.entities.News;
import com.example.sweater.database.entities.PlayerInfo;
import com.example.sweater.database.repos.PlayerInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerInfoService {
    @Autowired
    PlayerInfoRepo playerInfoRepo;

    void delete(long id) {
        playerInfoRepo.deleteById(id);
    }

    PlayerInfo detected(String playername) {
        return playerInfoRepo.findByPlayername(playername);
    }

    PlayerInfo detectedT(String team) {
        return playerInfoRepo.findByTeam(team);
    }

    PlayerInfo detectedC(String country) {
        return playerInfoRepo.findByCountry(country);
    }

    PlayerInfo detected(Integer rating) {
        return playerInfoRepo.findByRating(rating);
    }

    void editNews(Long id, String playername) {
        PlayerInfo playerInfo = playerInfoRepo.getOne(id);
        playerInfo.setPlayername(playername);
        playerInfoRepo.saveAndFlush(playerInfo);
    }

    void editNews1(Long id, Integer amountofmatches) {
        PlayerInfo playerInfo = playerInfoRepo.getOne(id);
        playerInfo.setAmountofmatches(amountofmatches);
        playerInfoRepo.saveAndFlush(playerInfo);
    }

    void editNews2(Long id, String counry) {
        PlayerInfo playerInfo = playerInfoRepo.getOne(id);
        playerInfo.setCountry(counry);
        playerInfoRepo.saveAndFlush(playerInfo);
    }

    void editNews3(Long id, String team) {
        PlayerInfo playerInfo = playerInfoRepo.getOne(id);
        playerInfo.setTeam(team);
        playerInfoRepo.saveAndFlush(playerInfo);
    }

    void editNews(Long id, Integer rating) {
        PlayerInfo playerInfo = playerInfoRepo.getOne(id);
        playerInfo.setRating(rating);
        playerInfoRepo.saveAndFlush(playerInfo);
    }

    public List<String> getPlayers() {
        List<String> players = new ArrayList<>();
        List<PlayerInfo> playerInfo = playerInfoRepo.findAll();
        for (PlayerInfo myPI : playerInfo) {
            players.add(myPI.getPlayername());
        }
        return players;

    }
}
