package com.example.sweater.database.entities;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, отображающий сущность Tournament(Турнир)
 */

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nameoft;
    private Integer amountofp;
    private String country;
    @OneToMany
    private List<PlayerInfo> playerInfo;

    @OneToMany
    private List<Match> match;

    public Tournament(String nameoft, Integer amountofp, String country, List<PlayerInfo> playerInfo, List<Match> match) {
        this.nameoft = nameoft;
        this.amountofp = amountofp;
        this.country = country;
        this.playerInfo = playerInfo;
        this.match = match;
    }
    public Tournament(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameoft() {
        return nameoft;
    }

    public void setNameoft(String nameoft) {
        this.nameoft = nameoft;
    }

    public Integer getAmountofp() {
        return amountofp;
    }

    public void setAmountofp(Integer amountofp) {
        this.amountofp = amountofp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<PlayerInfo> getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(List<PlayerInfo> playerInfo) {
        this.playerInfo = playerInfo;
    }

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }
}
