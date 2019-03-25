package com.example.sweater.database.repos;

import com.example.sweater.database.entities.Bet;
import com.example.sweater.database.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BetRepo extends JpaRepository<Bet, Long> {
}