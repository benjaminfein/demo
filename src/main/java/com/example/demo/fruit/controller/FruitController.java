package com.example.demo.fruit.controller;

import com.example.demo.fruit.model.Fruit;
import com.example.demo.fruit.service.FruitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
public class FruitController {
    final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/fruits")
    public Set<Fruit> getFruits() {
        return fruitService.getFruits();
    }

    @PostMapping("/createFruit")
    public HttpStatus createFruit(@RequestBody Fruit fruit) {
        fruitService.create(fruit);
        return HttpStatus.OK;
    }

    @PutMapping("/fruits/{id}")
    public HttpStatus updateFruit(@RequestBody Fruit fruit,@PathVariable Integer id) {
        try {
            Fruit fruitById = fruitService.findById(id);
            fruitService.updateFruit(fruitById, fruit);
            return HttpStatus.NO_CONTENT;
        } catch(Exception ex) {
            return HttpStatus.NOT_FOUND;
        }
    }

    @DeleteMapping("/fruits/{id}")
    public HttpStatus deleteFruits(@PathVariable Integer id) {
        try {
            Fruit fruitById = fruitService.findById(id);
            fruitService.deleteFruit(fruitById);
            return HttpStatus.NO_CONTENT;
        } catch(Exception ex) {
            return HttpStatus.NOT_FOUND;
        }
    }
}
