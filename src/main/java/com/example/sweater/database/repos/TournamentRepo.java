package com.example.sweater.database.repos;

import com.example.sweater.database.entities.PlayerInfo;
import com.example.sweater.database.entities.Tournament;
import com.example.sweater.database.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Date;

public interface  TournamentRepo extends JpaRepository<Tournament, Long> {
    Tournament findByNameoft (String nameoft);
    Tournament findByCountry (String country);

}
