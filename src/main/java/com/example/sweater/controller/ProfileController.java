package com.example.sweater.controller;

import com.example.sweater.database.entities.Bet;
import com.example.sweater.database.entities.PlayerInfo;
import com.example.sweater.database.entities.Users;
import com.example.sweater.database.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    UsersRepo usersRepo;
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping ("/profile")
    public List<Users> allUsers() {
        return usersRepo.findAll();

    }
    @GetMapping("/profile/{id}")
    public Users Profile(@PathVariable Users id){
        return id;
    }
}

