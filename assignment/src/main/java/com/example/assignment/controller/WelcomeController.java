package com.example.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class WelcomeController {

    @GetMapping("/")
    public String home() {
        return "/welcome.html";
    }

    @GetMapping("/success")
    public String success(
            @RequestParam String text1,
            @RequestParam String text2,
            Model model
    ) {
        model.addAttribute("text1", text1);
        model.addAttribute("text2", text2);
        log.info("First param : {}", text1);
        log.info("Second param : {}", text2);
        log.info(model.toString());
        return "/success.html";
    }
}
