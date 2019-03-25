package com.example.sweater.controller;


import com.example.sweater.database.entities.Users;
import com.example.sweater.database.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAnyAuthority('ADMIN')")
@RestController
public class ActiveController {
    @Autowired
    UsersRepo usersRepo;

    @GetMapping("profile/{id}/ban")
    public String BunUser(@PathVariable Users id){
        id.setActive(false);
        usersRepo.saveAndFlush(id);
        return "You are banned!!!";
    }

    @GetMapping("profile/{id}/unban")
    public String UnbunUser(@PathVariable Users id){
        id.setActive(true);
        usersRepo.saveAndFlush(id);
        return "You are unbanned!!!";
    }

}
