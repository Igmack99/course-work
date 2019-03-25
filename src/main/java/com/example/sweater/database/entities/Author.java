package com.example.sweater.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, отображающий сущность Author(автор)
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer amountofl;
    private Integer amountofn;
    @ManyToOne
    private Users users;
    @OneToMany
    private List<News> news;

    /**
     *
     * @param name имя автора
     * @param amountofl суммарное количество лайков, поставленных статьям автора
     * @param amountofn количество статей, написанных автором
     */

    public Author(String name, Integer amountofl, Integer amountofn, Users users, ArrayList<News> news) {
        this.name = name;
        this.amountofl = amountofl;
        this.amountofn = amountofn;
        this.users=users;
        this.news=news;
    }
    public Author() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountofl() {
        return amountofl;
    }

    public void setAmountofl(Integer amountofl) {
        this.amountofl = amountofl;
    }

    public Integer getAmountofn() {
        return amountofn;
    }

    public void setAmountofn(Integer amountofn) {
        this.amountofn = amountofn;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
