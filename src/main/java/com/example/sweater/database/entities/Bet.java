package com.example.sweater.database.entities;
import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Класс, отображающий сущность  Bet(ставка)
 */
@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer coef;
    private String eventname;
    //TODO: сделать ограничение на формочку
    @Min(0)
    private Integer betamount;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Match match;

    /**
     *
     * @param coef коэффициент ставки
     * @param eventname название события, на которок потсавил пользователь
     * @param betamount поставленная сумма
     */

    public Bet(Integer coef, String eventname, Integer betamount, Users users, Match match) {
        this.coef = coef;
        this.eventname = eventname;
        this.betamount = betamount;
        this.users = users;
        this.match = match;

    }
    public Bet(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCoef() {
        return coef;
    }

    public void setCoef(Integer coef) {
        this.coef = coef;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Integer getBetamount() {
        return betamount;
    }

    public void setBetamount(Integer bet_amount) {
        this.betamount = bet_amount;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

}
