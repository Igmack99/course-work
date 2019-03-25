package com.example.sweater.database.entities;

import javax.persistence.*;

    /**
     * Класс, отображающий сущность News(Новости, статьи)
     */
    @Entity
    public class NewsReview {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer id;

        @ManyToOne
        private Users users;

        private String comment;
        private Short score;

        @ManyToOne
        private News news;



        public NewsReview(Users users, String comment, Short score, News news) {
            this.users=users;
            this.comment = comment;
            this.score = score;
            this.news = news;
        }
        public NewsReview(){}
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public Short getScore() {
            return score;
        }

        public void setScore(Short score) {
            this.score = score;
        }

        public Users getUsers() {
            return users;
        }

        public void setUsers(Users users) {
            this.users = users;
        }

        public News getNews() { return news; }

        public void setNews(News news) { this.news = news; }
    }
