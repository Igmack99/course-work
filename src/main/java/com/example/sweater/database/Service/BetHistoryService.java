package com.example.sweater.database.Service;

import com.example.sweater.database.entities.BetHistory;
import com.example.sweater.database.repos.BetHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class BetHistoryService {
    @Autowired
    BetHistoryRepo betHistoryRepo;
    void delete (long id) {
        betHistoryRepo.deleteById(id);
    }

    BetHistory detected (boolean issuccess) { return  betHistoryRepo.findByIssuccess(issuccess);
    }
    BetHistory vremya (Date date) { return  betHistoryRepo.findByDate(date);
    }

    void editBetHistory(Long id, boolean issuccess){
        BetHistory betHistory = betHistoryRepo.getOne(id);
        betHistory.setIssuccess(issuccess);
        betHistoryRepo.saveAndFlush(betHistory);
    }
}
