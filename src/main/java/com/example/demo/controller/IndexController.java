package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/buttons")
    public String buttonsPage() {
        return "buttons";
    }

    @GetMapping("/cards")
    public String cardsPage() {
        return "cards";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/blank")
    public String blankPage() {
        return "blank";
    }
}
