package com.geektrust.powerOfGMan.validation;

import com.geektrust.powerOfGMan.entity.CoordinatesEntity;
import com.geektrust.powerOfGMan.exceptions.InvalidInputException;

public class Validation {

    // Method to validate the input coordinates entity
    public boolean validateInput(CoordinatesEntity coordinatesEntity) throws InvalidInputException {
        // Array of valid directions
        String[] validDirections = {"E", "W", "N", "S"};

        // Extracting values from coordinatesEntity
        int startX = coordinatesEntity.getStartX();
        int startY = coordinatesEntity.getStartY();
        int finalX = coordinatesEntity.getFinalX();
        int finalY = coordinatesEntity.getFinalY();
        String direction = coordinatesEntity.getDirection();

        // Checking if coordinates and direction are valid
        if (!(isValidCoordinate(startX) && isValidCoordinate(startY) && isValidCoordinate(finalX) && isValidCoordinate(finalY))
                || !isValidDirection(direction, validDirections)) {
            // Throwing an exception for invalid input
            throw new InvalidInputException("Coordinates must be between 0 and 6, and direction must be one of: E, W, N, S.");
        }
        // Returning true if input is valid
        return true;
    }

    // Method to check if coordinate is valid
    private boolean isValidCoordinate(int coordinate) {
        // Constants for minimum and maximum coordinate values
        final int MIN_COORDINATE_VALUE = 0;
        final int MAX_COORDINATE_VALUE = 6;
        // Checking if coordinate is within valid range
        return coordinate >= MIN_COORDINATE_VALUE && coordinate <= MAX_COORDINATE_VALUE;
    }

    // Method to check if direction is valid
    private boolean isValidDirection(String direction, String[] validDirections) {
        // Iterating through valid directions
        for (String value : validDirections) {
            // Checking if direction matches any of the valid directions
            if (value.equals(direction)) {
                return true; // Direction is valid
            }
        }
        return false; // Direction is not valid
    }
}