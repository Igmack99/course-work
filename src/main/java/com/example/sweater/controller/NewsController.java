package com.example.sweater.controller;

import com.example.sweater.database.Service.NewsService;
import com.example.sweater.database.entities.NewsReview;
import com.example.sweater.database.entities.News;
import com.example.sweater.database.repos.NewsReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.sweater.database.repos.NewsRepo;

import java.util.LinkedList;
import java.util.List;

@RestController
public class NewsController {
@Autowired
NewsRepo newsRepo;
@Autowired
NewsReviewRepo newsReviewRepo;
@Autowired
NewsService newsService;
    @GetMapping ("/news")
    public List<String> allNews() {
        List<News> news = newsRepo.findAll();
        List<News> newsToReturn = new LinkedList<>();
        for(News myNew : news){
            if(myNew.getIsApproved())
                newsToReturn.add(myNew);
        }

        return newsService.getTitles(newsToReturn);
    }

    @GetMapping("/news/{id}")
    public News News(@PathVariable News id){
        return id;
    }

    @GetMapping("/news/{id}/comments")
    public List<NewsReview> NewReviews(){
        return newsReviewRepo.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/news/delete")
    public List<News> deleteNew(@RequestParam long id){
        newsRepo.deleteById(id);
        return newsRepo.findAll();
    }
}

