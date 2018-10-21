package com.mattaretaylor.carpark.controller;

import com.mattaretaylor.carpark.model.Driver;
import com.mattaretaylor.carpark.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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
    public String viewById(Model model, @PathVariable Long id) {

        Driver d = service.findById(id);
        model.addAttribute("driver", d);

        model.addAttribute("pageTitle", "Driver: " +d.getName());
        return "driver/view";
    }

}
