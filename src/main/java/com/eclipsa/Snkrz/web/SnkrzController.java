package com.eclipsa.Snkrz.web;

import com.eclipsa.Snkrz.model.Snkrz;
import org.springframework.web.bind.annotation.*;

@RestController
public class SnkrzController {

    @GetMapping("/v1/get-sneakers")
    public Snkrz getAllSneakers(){
        return null;
    }

    @GetMapping("/v1/get-sneaker/{id}")
    public Snkrz getSneaker(Integer id){
        return null;
    }

    @PostMapping("v1/add-sneaker")
    public Snkrz addSneaker(){
        return null;
    }

    @PutMapping("/v1/update-sneaker")
    public Snkrz updateSneaker(){
        return null;
    }

    @DeleteMapping("/v1/delete-sneaker/{id}")
    public Snkrz deleteSneaker(){
        return null;
    }

    @DeleteMapping("/v1/delete-all-sneakers")
    public Snkrz deleteAllSneakers(){
        return null;
    }
}
