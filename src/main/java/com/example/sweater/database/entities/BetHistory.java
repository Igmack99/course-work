package com.example.sweater.database.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс, отображающий сущность BetHistory(история ставок)
 */

@Entity
public class BetHistory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Boolean issuccess;
    private Date date;
    @ManyToOne
    private Bet bet;
    @OneToOne
    private Users users;


    /**
     *
     * @param issuccess прошла ставка или нет
     * @param date дата ставки
     */

    public BetHistory(Boolean issuccess, Date date, Bet bet, Users users) {
        this.issuccess = issuccess;
        this.date = date;
        this.bet=bet;
        this.users = users;
    }
    public BetHistory(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(Boolean issuccess) {
        this.issuccess = issuccess;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
