package main.java.model;

import java.util.ArrayList;

public class User {

    private String name;
    public ArrayList<Shot> shots = new ArrayList<>();
    public int WarshipXPosition;
    public int WarshipYPosition;

    public User(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Shot> getShots() {
        return shots;
    }

    public void setShots(ArrayList<Shot> shots) {
        this.shots = shots;
    }
}
