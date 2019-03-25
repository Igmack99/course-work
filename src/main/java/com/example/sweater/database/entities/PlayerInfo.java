package com.example.sweater.database.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* Класс, отображающий сущность PlayerInfo(информация об игроке)
 */
@Entity
public class PlayerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String playername;
    private Integer amountofmatches;
    private String country;
    //TODO: сделать поиск по команде
    private String team;
    private Integer rating;

    public PlayerInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param playername имя игрока
     * @param amountofmatches количество матчей, сыгранных игроком
     * @param country страна, в которой роижлся игрок
     * @param team команда, в которой игрок выступает
     * @param rating рейтинг игрока
     */

    public PlayerInfo(String playername, Integer amountofmatches, String country, String team, Integer rating) {
        this.playername = playername;
        this.amountofmatches = amountofmatches;
        this.country = country;
        this.team = team;
        this.rating = rating;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public Integer getAmountofmatches() {
        return amountofmatches;
    }

    public void setAmountofmatches(Integer amountofmatches) {
        this.amountofmatches = amountofmatches;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String userlogin) {
        this.country = country;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
