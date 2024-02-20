package com.example.assignment.controller;

import com.example.assignment.model.FormSubmitRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class WelcomeController {

    @GetMapping("/")
    public String home(
            Model model
    ) {
        model.addAttribute("request", new FormSubmitRequest());
        return "welcome.html";
    }

    @PostMapping("/submit")
    public String success(
            @ModelAttribute FormSubmitRequest request,
            Model model
    ) {
        model.addAttribute("request", request);
        log.info(model.toString());
        return "success.html";
    }

}
