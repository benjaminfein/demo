package com.example.demo.fruit.model;

import java.util.Objects;

public class Fruit {
    private int id;
    private String name;
    private String season;
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return id == fruit.id && weight == fruit.weight && Objects.equals(name, fruit.name) && Objects.equals(season, fruit.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, season, weight);
    }
}
