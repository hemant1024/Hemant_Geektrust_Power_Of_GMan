package com.geektrust.powerOfGMan.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.geektrust.powerOfGMan.entity.CoordinatesEntity;

// Class for reading input
public class InputReader {

    // Method to read coordinates from file
    public CoordinatesEntity readInputFromFile(FileInputStream fileInputStream) throws FileNotFoundException {
        Scanner scanner = new Scanner(fileInputStream);
        int startX = 0, startY = 0, finalX = 0, finalY = 0;
        String direction = "";

        try {
            // Read start coordinates and direction
            String startLine = scanner.nextLine();
            String[] startParts = startLine.split("\\s+");
            startX = parseCoordinate(startParts[1]);
            startY = parseCoordinate(startParts[2]);
            direction = startParts[3];

            // Read final coordinates
            String finalLine = scanner.nextLine();
            String[] finalParts = finalLine.split("\\s+");
            finalX = parseCoordinate(finalParts[1]);
            finalY = parseCoordinate(finalParts[2]);
        } catch (Exception e) {
            // Handle invalid input format
            System.err.println("Invalid input format: " + e.getMessage());
            scanner.close();
            return null;
        } finally {
            // Close the scanner
            scanner.close();
        }

        // Create and return CoordinatesEntity object
        return new CoordinatesEntity(startX, startY, finalX, finalY, direction);
    }

    // Method to parse coordinate from input string
    private int parseCoordinate(String input) {
        String coord = input.replaceAll("\\D", "");
        return coord.isEmpty() ? 0 : Integer.parseInt(coord);
    }
}
