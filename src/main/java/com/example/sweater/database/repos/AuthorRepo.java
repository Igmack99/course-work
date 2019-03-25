package com.example.sweater.database.repos;

import com.example.sweater.database.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByName (String name);
    Author findByNews(String news);
    Author findByAmountofn (Integer amountofn);
}
