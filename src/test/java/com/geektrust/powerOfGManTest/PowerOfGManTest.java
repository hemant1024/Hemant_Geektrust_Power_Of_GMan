package com.geektrust.powerOfGManTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.geektrust.powerOfGMan.calculation.PowerCalculator;
import com.geektrust.powerOfGMan.calculation.TurnsCalculator;
import com.geektrust.powerOfGMan.entity.CoordinatesEntity;
import com.geektrust.powerOfGMan.exceptions.InvalidInputException;
import com.geektrust.powerOfGMan.input.InputReader;
import com.geektrust.powerOfGMan.validation.Validation;

public class PowerOfGManTest {

    // Test for validating input
    @Test
    public void testValidInput() throws FileNotFoundException, InvalidInputException {
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity(2, 1, 4, 3, "E");
        Validation validation = new Validation();

        boolean isValid = validation.validateInput(coordinatesEntity);

        Assertions.assertTrue(isValid);
    }

    // Test for invalid coordinates
    @Test
    public void testInvalidCoordinates() throws FileNotFoundException, InvalidInputException {
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity(7, 3, 4, 5, "E");
        Validation validation = new Validation();

        Assertions.assertThrows(InvalidInputException.class, () -> validation.validateInput(coordinatesEntity));
    }

    // Test for invalid direction
    @Test
    public void testInvalidDirection() throws FileNotFoundException, InvalidInputException {
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity(2, 3, 4, 5, "X");
        Validation validation = new Validation();

        Assertions.assertThrows(InvalidInputException.class, () -> validation.validateInput(coordinatesEntity));
    }

    // Test for calculating turns when moving vertically upwards
    @Test
    public void testCalculateTurnsVerticalUpwards() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(0, 3, "N");

        Assertions.assertEquals(0, result);
    }

    // Test for calculating turns when moving vertically downwards
    @Test
    public void testCalculateTurnsVerticalDownwards() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(0, -2, "S");

        Assertions.assertEquals(0, result);
    }

    // Test for calculating turns when moving horizontally right
    @Test
    public void testCalculateTurnsHorizontalRight() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(4, 0, "E");

        Assertions.assertEquals(0, result);
    }

    // Test for calculating turns when moving horizontally left
    @Test
    public void testCalculateTurnsHorizontalLeft() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(-2, 0, "W");

        Assertions.assertEquals(0, result);
    }

    // Test for calculating turns in quadrant 1
    @Test
    public void testCalculateTurnsQuadrant1() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(3, 4, "N");

        Assertions.assertEquals(1, result);
    }

    // Test for calculating turns in quadrant 2
    @Test
    public void testCalculateTurnsQuadrant2() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(-5, 2, "S");

        Assertions.assertEquals(2, result);
    }

    // Test for calculating turns in quadrant 3
    @Test
    public void testCalculateTurnsQuadrant3() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(-4, -3, "E");

        Assertions.assertEquals(2, result);
    }

    // Test for calculating turns in quadrant 4
    @Test
    public void testCalculateTurnsQuadrant4() {
        TurnsCalculator calculator = new TurnsCalculator();
        int result = calculator.calculateTurns(6, -5, "W");

        Assertions.assertEquals(2, result);
    }

    // Test for calculating remaining power
    @Test
    public void testRemainingPowerCalculation() {
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity(2, 1, 4, 3, "E");
        PowerCalculator powerCalculator = new PowerCalculator();

        int remainingPower = powerCalculator.calculate(coordinatesEntity);

        Assertions.assertEquals(155, remainingPower);
    }
    
    // Test for calculating power when moving in opposite direction
    @Test
    public void testPowerInOppositeDirection() {
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity(2, 1, 2, 4, "S");
        PowerCalculator powerCalculator = new PowerCalculator();

        int remainingPower = powerCalculator.calculate(coordinatesEntity);

        Assertions.assertEquals(160, remainingPower);
    }

    // Test for validating input from file
    @Test
    public void testValidInputFile() throws FileNotFoundException, InvalidInputException {
        FileInputStream fis = new FileInputStream("sample_input/input1.txt");
        InputReader inputReader = new InputReader();

        CoordinatesEntity coordinatesEntity = inputReader.readInputFromFile(fis);
        Validation validation = new Validation();

        Assertions.assertTrue(validation.validateInput(coordinatesEntity));
    }

    // Test for handling negative coordinates
    @Test
    public void testTravelPowerWithNegativeCoordinates() throws FileNotFoundException, InvalidInputException {
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity(-1, -1, 1, 1, "E");
        Validation validation = new Validation();

        Assertions.assertThrows(InvalidInputException.class, () -> validation.validateInput(coordinatesEntity));
    }

    // Test for handling empty input file
    @Test
    public void testReadInputFromFile_EmptyInputFile_ReturnsNull() throws FileNotFoundException, InvalidInputException {
        FileInputStream fis = new FileInputStream("sample_input/empty_input.txt");
        InputReader inputReader = new InputReader();

        CoordinatesEntity result;
        try {
            result = inputReader.readInputFromFile(fis);
        } catch (FileNotFoundException e) {
            result = null;
        }

        Assertions.assertNull(result);
    }
}