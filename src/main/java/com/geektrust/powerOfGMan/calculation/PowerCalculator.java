package com.geektrust.powerOfGMan.calculation;

import com.geektrust.powerOfGMan.entity.CoordinatesEntity;

// Class for calculating power
public class PowerCalculator {

    // Instance of TurnsCalculator
    TurnsCalculator turnsCalculator = new TurnsCalculator();
    // Total power set to 200
    int totalPower = 200;
    // Power deduction for a move
    int deduction_move = 10;
    // Power deduction for a turn
    int deduction_turn = 5;

    public int calculate(CoordinatesEntity coordinatesEntity) {

        // Extracting coordinates and direction from the entity
        int startX = coordinatesEntity.getStartX();
        int startY = coordinatesEntity.getStartY();
        int finalX = coordinatesEntity.getFinalX();
        int finalY = coordinatesEntity.getFinalY();
        String direction = coordinatesEntity.getDirection();

        // Calculating the differences in coordinates
        int xDiff = finalX - startX;
        int yDiff = finalY - startY;

        // Variable to track turns required
        int turns = turnsCalculator.calculateTurns(xDiff, yDiff, direction);

        // Calculating remaining power
        int remainingPower = totalPower - (Math.abs(xDiff) + Math.abs(yDiff)) * deduction_move - turns * deduction_turn;
        
        return remainingPower;
    }    
}