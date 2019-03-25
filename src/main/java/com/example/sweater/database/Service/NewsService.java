package com.example.sweater.database.Service;

import com.example.sweater.database.entities.News;
import com.example.sweater.database.repos.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepo newsRepo;

    void delete(long id) {
        newsRepo.deleteById(id);
    }

    News detected (String title) { return  newsRepo.findByTitle(title);
    }

    News detectedA (String author) { return  newsRepo.findByAuthor(author);
    }

    void editNews(Long id, String title) {
        News news = newsRepo.getOne(id);
        news.setTitle(title);
        newsRepo.saveAndFlush(news);
    }
    public String Title(Long id){
        return newsRepo.getOne(id).getTitle();
    }


    public List<String> getTitles(List<News> news){
        List<String> titles = new ArrayList<>();
        for(News myNew : news){
            titles.add(myNew.getTitle());
            }
    return titles;

    }

}