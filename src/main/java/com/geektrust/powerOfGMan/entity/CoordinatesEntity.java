package com.geektrust.powerOfGMan.entity;

// Class representing coordinates entity
public class CoordinatesEntity {

    // Private fields representing coordinates and direction
    private int startX;
    private int startY;
    private int finalX;
    private int finalY;
    private String direction;

    // Constructor to initialize coordinates entity
    public CoordinatesEntity(int startX, int startY, int finalX, int finalY, String direction) {
        this.startX = startX;
        this.startY = startY;
        this.finalX = finalX;
        this.finalY = finalY;
        this.direction = direction;
    }

    // Getter method for startX
    public int getStartX() {
        return startX;
    }

    // Setter method for startX
    public void setStartX(int startX) {
        this.startX = startX;
    }

    // Getter method for startY
    public int getStartY() {
        return startY;
    }

    // Setter method for startY
    public void setStartY(int startY) {
        this.startY = startY;
    }

    // Getter method for finalX
    public int getFinalX() {
        return finalX;
    }

    // Setter method for finalX
    public void setFinalX(int finalX) {
        this.finalX = finalX;
    }

    // Getter method for finalY
    public int getFinalY() {
        return finalY;
    }

    // Setter method for finalY
    public void setFinalY(int finalY) {
        this.finalY = finalY;
    }

    // Getter method for direction
    public String getDirection() {
        return direction;
    }

    // Setter method for direction
    public void setDirection(String direction) {
        this.direction = direction;
    }
}