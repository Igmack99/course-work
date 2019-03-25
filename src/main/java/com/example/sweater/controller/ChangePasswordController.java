package com.example.sweater.controller;

import com.example.sweater.database.entities.Users;
import com.example.sweater.database.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/changepassword")
    public String changePassword(@RequestParam long id,
                                 @RequestParam String newPassword){
        usersRepo.getOne(id).setPassword(encoder.encode(newPassword));
        usersRepo.saveAndFlush(usersRepo.getOne(id));
        return "main";

    }
    @GetMapping("/changepassword")
    public String FormOfChange(@AuthenticationPrincipal Users users, Model model)

    {
     model.addAttribute("user", users);
        return "changePassword";
    }
}
