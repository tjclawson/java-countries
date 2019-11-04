package com.tjclawson.javacountries;

public class Country {

    private String name;
    private long population;
    private long mass;
    private int medianAge;

    public Country(String name, long population, long mass, int medianAge) {
        this.name = name;
        this.population = population;
        this.mass = mass;
        this.medianAge = medianAge;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public long getPopulation() { return population; }

    public void setPopulation(long population) { this.population = population; }

    public long getMass() { return mass; }

    public void setMass(long mass) { this.mass = mass; }

    public int getMedianAge() { return medianAge; }

    public void setMedianAge(int medianAge) { this.medianAge = medianAge; }
}
