package com.blueworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.blueworld.model.User;
import com.blueworld.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/health")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId,
                        @RequestParam String password,
                        Model model) {

        if (userRepository.validateUser(userId, password)) {
            model.addAttribute("user", userId);
            return "welcome";
        }
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String userId,
                           @RequestParam String password) {

        userRepository.saveUser(new User(userId, password));
        return "login";
    }
}


