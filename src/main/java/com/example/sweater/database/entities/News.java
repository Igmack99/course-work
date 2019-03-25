package com.example.sweater.database.entities;

import javax.persistence.*;

/**
 * Класс, отображающий сущность News(Новости, статьи)
 */
@Entity
public class News {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private boolean isApproved;
    @ManyToOne
    private Author author;

    /**
     *
     * @param title название статьи
     */

    public News(String title, Author author, String content, boolean isApproved) {
        this.title = title;
        this.author=author;
        this.content = content;
        this.isApproved = isApproved;
    }

    public News() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() { return content; }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsApproved() { return isApproved; }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
