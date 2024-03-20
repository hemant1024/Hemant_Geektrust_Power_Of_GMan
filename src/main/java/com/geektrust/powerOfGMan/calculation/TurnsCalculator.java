package com.geektrust.powerOfGMan.calculation;

public class TurnsCalculator {
    private static final String DIRECTION_EAST = "E";
    private static final String DIRECTION_WEST = "W";
    private static final String DIRECTION_NORTH = "N";
    private static final String DIRECTION_SOUTH = "S";

    // Method to calculate the number of turns required
    public int calculateTurns(int xDiff, int yDiff, String direction) {

        // If there's no horizontal difference, only vertical movement
        if (xDiff == 0) {
            return calculateVerticalTurns(yDiff, direction);
        } 
        // If there's no vertical difference, only horizontal movement
        else if (yDiff == 0) {
            return calculateHorizontalTurns(xDiff, direction);
        } 
        // Otherwise, movement in both vertical and horizontal directions
        else {
            return calculateQuadrantTurns(xDiff, yDiff, direction);
        }
    }

    // Method to calculate turns when moving vertically
    private int calculateVerticalTurns(int yDiff, String direction) {

        // Initializing turns to 0
        int turns = 0;
        if (yDiff < 0) { // Moving downwards
            if (direction.equals(DIRECTION_WEST) || direction.equals(DIRECTION_EAST)) {
                turns = 1;
            } else if (direction.equals(DIRECTION_NORTH)) {
                turns = 2;
            }
            return turns;
        } else { // Moving upwards
            if (direction.equals(DIRECTION_EAST) || direction.equals(DIRECTION_WEST)) {
                turns = 1;
            } else if (direction.equals(DIRECTION_SOUTH)) {
                turns = 2;
            }
            return turns;
        }
    }

    // Method to calculate turns when moving horizontally
    private int calculateHorizontalTurns(int xDiff, String direction) {

        // Initializing turns to 0
        int turns = 0;
        if (xDiff < 0) { // Moving left
            if (direction.equals(DIRECTION_SOUTH) || direction.equals(DIRECTION_NORTH)) {
                turns = 1;
            } else if (direction.equals(DIRECTION_EAST)) {
                turns = 2;
            }
            return turns;
        } else { // Moving right
            if (direction.equals(DIRECTION_SOUTH) || direction.equals(DIRECTION_NORTH)) {
                turns = 1;
            } else if (direction.equals(DIRECTION_WEST)) {
                turns = 2;
            }
            return turns;
        }
    }

    // Method to calculate turns when moving diagonally
    private int calculateQuadrantTurns(int xDiff, int yDiff, String direction) {

        // Check for positve travel on X axis
        boolean xAxisPositive = xDiff > 0;
        // Check for positve travel on Y axis
        boolean yAxisPositive = yDiff > 0;

        if (xAxisPositive && yAxisPositive) { // Travelling in 1st quadrant
            return direction.equals(DIRECTION_SOUTH) || direction.equals(DIRECTION_WEST) ? 2 : 1;
        } else if (xAxisPositive && !yAxisPositive) { // Travelling in 4th quadrant
            return direction.equals(DIRECTION_NORTH) || direction.equals(DIRECTION_WEST) ? 2 : 1;
        } else if (!xAxisPositive && yAxisPositive) { // Travelling in 2nd quadrant
            return direction.equals(DIRECTION_SOUTH) || direction.equals(DIRECTION_EAST) ? 2 : 1;
        } else { // Travelling in 3rd quadrant
            return direction.equals(DIRECTION_NORTH) || direction.equals(DIRECTION_EAST) ? 2 : 1;
        }
    }
}