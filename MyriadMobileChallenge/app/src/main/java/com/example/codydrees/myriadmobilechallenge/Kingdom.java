package com.example.codydrees.myriadmobilechallenge;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Cody Drees on 3/12/2016.
 */
public class Kingdom implements Serializable {
    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private String description;

    @Expose
    private String image;

    @Expose
    private String population;

    @Expose
    private String climate;

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
