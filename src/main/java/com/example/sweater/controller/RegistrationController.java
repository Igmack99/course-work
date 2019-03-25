package com.example.sweater.controller;
import com.example.sweater.database.Service.MailSender;
import com.example.sweater.database.Service.UsersService;
import com.example.sweater.database.entities.Role;
import com.example.sweater.database.entities.Users;
import com.example.sweater.database.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegistrationController {
    @Autowired
    private UsersRepo userRepo;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private UsersService usersService;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Users user, Map<String, Object> model) {
        Users userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.saveAndFlush(user);

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = usersService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }
}