package com.autorepairshop.controller;

import com.autorepairshop.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    private final UserDAO userDAO;

    public LoginController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        if (userDAO.validate(username, password)) {
            session.setAttribute("user", username);
            return "redirect:/products";
        } else {
            return "login";
        }
    }
}
