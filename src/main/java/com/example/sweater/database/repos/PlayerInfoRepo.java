package com.example.sweater.database.repos;

import com.example.sweater.database.entities.PlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerInfoRepo extends JpaRepository<PlayerInfo, Long> {
    PlayerInfo findByPlayername (String playername);
    PlayerInfo findByCountry (String country);
    PlayerInfo findByTeam (String team);
    PlayerInfo findByRating (Integer rating);
}
