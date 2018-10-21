package com.mattaretaylor.carpark.controller;

import com.mattaretaylor.carpark.model.Vehicle;
import com.mattaretaylor.carpark.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("vehicleList", service.findAll());

        model.addAttribute("pageTitle", "Registered Vehicles");
        return "vehicle/index";
    }

    @RequestMapping("/view/{id}")
    public String viewById(Model model, @PathVariable Long id) {

        Vehicle v = service.findById(id);
        model.addAttribute("vehicle", v);

        model.addAttribute("pageTitle", v.getType() +": "+v.getRegistration());
        return "vehicle/view";
    }
}
