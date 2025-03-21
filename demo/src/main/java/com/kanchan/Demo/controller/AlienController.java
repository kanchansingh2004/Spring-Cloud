package com.kanchan.Demo.controller;

import com.rishi.Demo.AlienRepo;
import com.rishi.Demo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;
    @GetMapping("aliens")
    //@ResponseBody
    public List<Alien> getAliens() {
       List<Alien> aliens = repo.findAll();
        return aliens;
    }
    @GetMapping("alien/{aid}")
    //@ResponseBody
    public Alien getAlien(@PathVariable("aid") int aid){
        Alien alien = repo.findById(aid).orElse(new Alien("",0));
        return alien;
    }
    @PostMapping("alien")
    public Alien addAlien(@RequestBody   Alien alien){
        repo.save(alien);
        return alien;
    }
}
