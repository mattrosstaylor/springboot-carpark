package com.mattaretaylor.carpark.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPage {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("pageTitle", "Goat Carpark - Home");
        return "main-index";
    }
}
