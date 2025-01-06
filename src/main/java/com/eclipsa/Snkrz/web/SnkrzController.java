package com.eclipsa.Snkrz.web;

import com.eclipsa.Snkrz.model.Snkrz;
import com.eclipsa.Snkrz.service.SnkrzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SnkrzController {
    private final SnkrzService snkrzService;

    public SnkrzController(SnkrzService snkrzService) {
        this.snkrzService = snkrzService;
    }

    @GetMapping("/v1/get-sneakers")
    public Iterable<Snkrz> getAllSneakers(){
        // if (snkrzService == null){
        //     return (Iterable<Snkrz>) ResponseEntity.status(HttpStatus.NOT_FOUND).body("No sneakers found");
        // }
        return snkrzService.get();
    }

    @GetMapping("/v1/get-sneaker/{id}")
    public Snkrz getSneaker(Integer id){
        return snkrzService.getById(id);
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
