package com.mattaretaylor.carpark.controller;

import com.mattaretaylor.carpark.model.Driver;
import com.mattaretaylor.carpark.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("driverList", service.findAll());

        model.addAttribute("pageTitle", "Registered Drivers");
        return "driver/index";
    }

    @RequestMapping("/view/{id}")
    public String view(Model model, @PathVariable Long id) {

        Driver d = service.getById(id);
        model.addAttribute("driver", d);

        model.addAttribute("pageTitle", "Driver: " +d.getName());
        return "driver/view";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {

        Driver d = service.getById(id);
        model.addAttribute("driver", d);

        model.addAttribute("pageTitle", "Edit Driver " +id);
        return "driver/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(Model model, @ModelAttribute Driver d, @PathVariable Long id, RedirectAttributes ra) {

        //service.save(d);

        ra.addAttribute("id", id);
        return "redirect:/drivers/view/{id}";
    }

}
