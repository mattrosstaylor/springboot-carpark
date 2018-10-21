package com.mattaretaylor.carpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("pageTitle", "Goat Carpark - Home");
        return "index";
    }
}
