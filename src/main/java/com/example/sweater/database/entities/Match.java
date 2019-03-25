package com.example.sweater.database.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс, отображающий сущность Match(матч);
 */
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private PlayerInfo playerInfo;
    @ManyToOne
    private PlayerInfo playerInfo1;
    @ManyToOne
    private Tournament tournament;


    private Integer event1;
    private Integer event2;
    private Date date;

    @ManyToOne
    private PlayerInfo winner;

    /**
     *
     * @param event1 коэффициент на первое событие
     * @param event2 коэффициент на второе событие
     * @param date дата матча
     * @param winner имя победителя
     */
    public Match(PlayerInfo playerInfo, PlayerInfo playerInfo1, Tournament tournament, Integer event1, Integer event2, Date date, PlayerInfo winner) {
        this.playerInfo = playerInfo;
        this.playerInfo1 = playerInfo1;
        this.winner = winner;
        this.tournament = tournament;
        this.event1 = event1;
        this.event2 = event2;
        this.date = date;
    }
    public Match(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public PlayerInfo getPlayerInfo1() {
        return playerInfo1;
    }

    public void setPlayerInfo1(PlayerInfo playerInfo1) {
        this.playerInfo1 = playerInfo1;
    }

    public PlayerInfo getWinner() {
        return winner;
    }

    public void setWinner(PlayerInfo winner) { this.winner = winner;}

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
    public Integer getEvent1() {
        return event1;
    }

    public void setEvent1(Integer event1) {
        this.event1 = event1;
    }

    public Integer getEvent2() {
        return event2;
    }

    public void setEvent2(Integer event2) {
        this.event2 = event2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
