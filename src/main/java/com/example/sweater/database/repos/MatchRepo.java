package com.example.sweater.database.repos;

import com.example.sweater.database.entities.Match;
import com.example.sweater.database.entities.PlayerInfo;
import com.example.sweater.database.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;

public interface  MatchRepo extends JpaRepository<Match, Long> {
    Match findByDate (Date date);
    Match findByPlayerInfo (PlayerInfo playerInfo);
    Match findByTournament (Tournament tournament);
    Match findByWinner (PlayerInfo winner);

}
