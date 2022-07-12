package com.example.frogbackendprogrammingtest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/")
    public String indexPage(Model model){
        return "home";
    }
}
