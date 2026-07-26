// PalmerPenguins.java
// Amanda Perron
// July 19th 2026
// Refactored Palmer Penguins analysis using object-oriented approach

package edu.fscj.cop2800c.penguin;

public class PalmerPenguins {
    public static void main(String[] args) {
        // Create an instance of PenguinAnalyzer
        PenguinAnalyzer analyzer = new PenguinAnalyzer();

        // Read CSV data
        analyzer.readPenguinData();

        // Print formatted output
        analyzer.printPenguinData();

        // Save results to a file
        analyzer.writePenguinData();
    }
}