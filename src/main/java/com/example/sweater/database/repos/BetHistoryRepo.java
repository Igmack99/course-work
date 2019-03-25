package com.example.sweater.database.repos;

import com.example.sweater.database.entities.BetHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;


public interface BetHistoryRepo extends JpaRepository<BetHistory, Long> {
    BetHistory findByDate (Date date);
    BetHistory findByIssuccess (boolean issuccess);
}
