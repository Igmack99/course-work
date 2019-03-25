package com.example.sweater.controller;

import com.example.sweater.database.entities.Bet;
import com.example.sweater.database.entities.News;
import com.example.sweater.database.entities.Role;
import com.example.sweater.database.entities.Users;
import com.example.sweater.database.repos.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@PreAuthorize("hasAuthority('AUTHOR') or hasAuthority('ADMIN')")
@Controller
public class NewsAuthorController {
    @Autowired
    NewsRepo newsRepo;

    @GetMapping("/news/add")
    public String getNewsForm(
            @AuthenticationPrincipal Users user
    ){
        System.out.println(user.getRoles().contains(Role.ADMIN));
        return "addNews";
    }

    @PostMapping("/news/add")
    public String addNews(News news, @AuthenticationPrincipal Users user){
        newsRepo.saveAndFlush(news);
        return "addNews";
    }

}
