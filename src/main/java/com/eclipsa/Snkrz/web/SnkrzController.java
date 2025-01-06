package com.eclipsa.Snkrz.web;

import com.eclipsa.Snkrz.model.Snkrz;
import com.eclipsa.Snkrz.service.SnkrzService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@RestController
public class SnkrzController {
    private final SnkrzService snkrzService;

    public SnkrzController(SnkrzService snkrzService) {
        this.snkrzService = snkrzService;
    }

    @GetMapping("/get-sneakers")
    public ResponseEntity<?> getAllSneakers(){
        Iterable<Snkrz>sneaker = snkrzService.get();
        if(sneaker == null){
            return new ResponseEntity<>("No sneakers found" ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sneaker, HttpStatus.OK);
    }

    @GetMapping("/api/v1/get-sneaker/{id}")
    public ResponseEntity<?> getSneaker(@PathVariable Integer id){
        Snkrz sneaker =  snkrzService.getById(id);
        if(sneaker == null){
            return new ResponseEntity<>("Sneaker not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sneaker, HttpStatus.OK);
    }

    @PostMapping("/api/v1/add-sneaker")
    public ResponseEntity<?> addSneaker(@Valid @RequestBody Snkrz snkrz, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Snkrz sneaker = snkrzService.addSneaker(snkrz.getName(), snkrz.getBrand(), snkrz.getImages(), snkrz.getModel());
        if(sneaker == null){
            return new ResponseEntity<>("Failed to add sneaker, kindly fill out all fields" ,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sneaker, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/update-sneaker")
    public ResponseEntity<?> updateSneaker(@Valid @RequestBody Snkrz snkrz, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Snkrz sneaker = snkrzService.updateSneaker(snkrz.getId(), snkrz.getName(), snkrz.getBrand(), snkrz.getImages(), snkrz.getModel());
        if(sneaker == null){
            return new ResponseEntity<>("Failed to update sneaker, kindly fill out all fields" ,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(sneaker, HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/delete-sneaker/{id}")
    public ResponseEntity<?> deleteSneaker(@PathVariable Integer id){
        Snkrz sneaker = snkrzService.removeSneakerById(id);
        if(sneaker == null){
            return new ResponseEntity<>("Sneaker not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Sneaker deleted", HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/delete-all-sneakers")
    public Snkrz deleteAllSneakers(){
        return null;
    }
}
