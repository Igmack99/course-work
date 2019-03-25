package com.example.sweater.database.Service;

import com.example.sweater.database.entities.Author;
import com.example.sweater.database.entities.PlayerInfo;
import com.example.sweater.database.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    void delete (long id) {
        authorRepo.deleteById(id);
    }

    Author SearchByName (String name) { return  authorRepo.findByName(name);
    }
    Author SearchByNews (String news) { return  authorRepo.findByNews(news);
    }
    Author SearchByAmountofn (Integer amountofn) { return  authorRepo.findByAmountofn(amountofn);
    }

    void editAuthor(Long id, String name){
        Author author = authorRepo.getOne(id);
        author.setName(name);
        authorRepo.saveAndFlush(author);
    }
    void editAuthor1(Long id, String news){
        Author author = authorRepo.getOne(id);
        author.setName(news);
        authorRepo.saveAndFlush(author);
    }
    void editAuthor2(Long id, Integer amountofl) {
        Author author = authorRepo.getOne(id);
        author.setAmountofl(amountofl);
        authorRepo.saveAndFlush(author);
    }

    public List<String> getAuthors() {
        List<String> authors = new ArrayList<>();
        List<Author> author = authorRepo.findAll();
        for (Author myA : author) {
            authors.add(myA.getName());
        }
        return authors;

    }
}