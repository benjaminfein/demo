package com.example.demo.fruit.service;

import com.example.demo.fruit.model.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FruitServiceTest {

    @Test
    public void createFruit() {
        FruitService service = new FruitService();
        Fruit createFruit = service.createFruit(loadData());
        Assertions.assertEquals(1, createFruit.getId(), "id is not equal for fruit");
    }

    public Fruit loadData() {
        Fruit fruit = new Fruit();
        fruit.setId(1);
        fruit.setName("banana");
        fruit.setSeason("spring");
        fruit.setWeight(150);
        return fruit;
    }
}
