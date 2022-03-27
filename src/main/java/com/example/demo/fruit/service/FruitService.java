package com.example.demo.fruit.service;

import com.example.demo.fruit.model.Fruit;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FruitService {
    static Set<Fruit> fruits = new HashSet<>();

    static {
        fruits.add(createFruit(1, "mango", "summer", 250));
        fruits.add(createFruit(2, "strawberry", "spring", 50));
        fruits.add(createFruit(3, "blackberry", "autoumn", 30));
    }

    public Set<Fruit> findAll() {
        return fruits;
    }

    public Fruit createFruit(Fruit fruit) {
        if (!fruits.contains(fruit)) {
            fruits.add(fruit);
            return fruit;
        }
        throw new RuntimeException("Such fruit already contains");
    }

    private static Fruit createFruit(Integer id, String name, String season, int weight) {
        Fruit fruit = new Fruit();
        fruit.setId(id);
        fruit.setName(name);
        fruit.setSeason(season);
        fruit.setWeight(weight);
        return fruit;
    }

    public Fruit findById(Integer id) {
        return fruits.stream()
                .filter(fruit -> fruit.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such fruit by id: " + id));
    }

    public void updateFruit(Fruit exitingFruit, Fruit fruitForUpdate) {
        exitingFruit.setName(fruitForUpdate.getName());
        exitingFruit.setWeight(fruitForUpdate.getWeight());
        exitingFruit.setSeason(fruitForUpdate.getSeason());
    }

    public void deleteFruit(Fruit fruitForDeletion) {
        boolean isDeleted = fruits.remove(fruitForDeletion);
        if (!isDeleted) {
            throw new RuntimeException("The object is not deleted for some reason");
        }
    }
}
