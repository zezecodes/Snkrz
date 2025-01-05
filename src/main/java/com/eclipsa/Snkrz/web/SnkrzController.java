package com.eclipsa.Snkrz.web;

import com.eclipsa.Snkrz.model.SnkrzModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class SnkrzController {

    @GetMapping("/v1/get-sneakers")
    public SnkrzModel getAllSneakers(){
        return null;
    }

    @GetMapping("/v1/get-sneaker/{id}")
    public SnkrzModel getSneaker(Integer id){
        return null;
    }

    @PostMapping("v1/add-sneaker")
    public SnkrzModel addSneaker(){
        return null;
    }

    @PutMapping("/v1/update-sneaker")
    public SnkrzModel updateSneaker(){
        return null;
    }

    @DeleteMapping("/v1/delete-sneaker/{id}")
    public SnkrzModel deleteSneaker(){
        return null;
    }

    @DeleteMapping("/v1/delete-all-sneakers")
    public SnkrzModel deleteAllSneakers(){
        return null;
    }
}
