package com.eclipsa.Snkrz.service;

import com.eclipsa.Snkrz.model.Snkrz;
import com.eclipsa.Snkrz.repository.SnkrzRepository;
import org.springframework.stereotype.Service;

@Service
public class SnkrzService {
    private final SnkrzRepository snkrzRepository;

    public SnkrzService(SnkrzRepository snkrzRepository) {
        this.snkrzRepository = snkrzRepository;
    }

    public Iterable<Snkrz> get(){
        return snkrzRepository.findAll();
    }

    public Snkrz getById(Integer id){
        return snkrzRepository.findById(id).orElse(null);
    }

    public Snkrz addSneaker(String name, String brand, String[] images, String model){
        Snkrz sneaker = new Snkrz();
        sneaker.setName(name);
        sneaker.setBrand(brand);
        sneaker.setImages(images);
        sneaker.setModel(model);
        snkrzRepository.save(sneaker);
        return sneaker;
    }

    public Snkrz updateSneaker(Integer id, String name, String brand, String[] images, String model){
        Snkrz sneaker = snkrzRepository.findById(id).orElse(null);
        if(sneaker == null){
            return null;
        }
        sneaker.setName(name);
        sneaker.setBrand(brand);
        sneaker.setImages(images);
        sneaker.setModel(model);
        snkrzRepository.save(sneaker);
        return sneaker;
    }

    public Snkrz removeAllSneakers(){
        snkrzRepository.deleteAll();
        return null;
    }

    public Snkrz removeSneakerById(Integer id){
        snkrzRepository.deleteById(id);
        return null;
    }

}
