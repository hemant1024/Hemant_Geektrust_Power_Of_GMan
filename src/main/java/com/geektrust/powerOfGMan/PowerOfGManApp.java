package com.geektrust.powerOfGMan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.geektrust.powerOfGMan.calculation.PowerCalculator;
import com.geektrust.powerOfGMan.entity.CoordinatesEntity;
import com.geektrust.powerOfGMan.exceptions.InvalidInputException;
import com.geektrust.powerOfGMan.input.InputReader;
import com.geektrust.powerOfGMan.validation.Validation;

public class PowerOfGManApp {

    // Main method to start the application
    public static void main(String[] args) {
        try {
            // Open input file stream
            FileInputStream inputStream = new FileInputStream(args[0]);

            // Read input coordinates
            InputReader inputReader = new InputReader();
            CoordinatesEntity coordinatesEntity = inputReader.readInputFromFile(inputStream);

            // Validate input
            Validation validation = new Validation();
            if (validation.validateInput(coordinatesEntity)) {
                // Calculate power
                PowerCalculator powerCalculator = new PowerCalculator();
                int power = powerCalculator.calculate(coordinatesEntity);
                System.out.println("POWER " + power);
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.err.println("File Not Found: " + e.getMessage());
        } catch (InvalidInputException e) {
            // Handle invalid input exception
            System.err.println("Invalid input: " + e.getMessage());
        }
    }
}
