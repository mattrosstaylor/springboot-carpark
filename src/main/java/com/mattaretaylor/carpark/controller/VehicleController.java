package com.mattaretaylor.carpark.controller;

import com.mattaretaylor.carpark.model.Vehicle;
import com.mattaretaylor.carpark.repository.VehicleTypeRepository;
import com.mattaretaylor.carpark.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @Autowired
    private VehicleTypeRepository vehicleTypes;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("vehicleList", service.findAll());

        model.addAttribute("pageTitle", "Registered Vehicles");
        return "vehicle/index";
    }

    @RequestMapping("/view/{id}")
    public String view(Model model, @PathVariable Long id) {

        Vehicle v = service.getById(id);
        model.addAttribute("vehicle", v);

        model.addAttribute("pageTitle", v.getType().getName() +": "+v.getRegistration());
        return "vehicle/view";
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {

        Vehicle v = service.getById(id);
        model.addAttribute("vehicle", v);
        model.addAttribute("vehicleTypes", vehicleTypes.findAll());

        model.addAttribute("pageTitle", "Edit Vehicle " +id);
        return "vehicle/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(Model model, RedirectAttributes ra, @ModelAttribute Vehicle v, @PathVariable Long id) {

        service.save(v);

        ra.addAttribute("id", id);
        return "redirect:/vehicles/view/{id}";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("vehicleTypes", vehicleTypes.findAll());
        model.addAttribute("pageTitle", "Add new Vehicle");
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle/add";
    }

    @PostMapping("add")
    public String add(RedirectAttributes ra, Vehicle v) {
        service.save(v);
        return "redirect:/vehicles/";
    }

    @PostMapping("/delete/{id}")
    public String delete(RedirectAttributes ra, @ModelAttribute Vehicle v, @PathVariable Long id) {

        service.delete(v);

        ra.addAttribute("id", id);
        return "redirect:/vehicles/";
    }
}
