// PenguinAnalyzer.java
// Amanda Perron
// July 19th 2026
// Handles file reading, processing, and writing data

package edu.fscj.cop2800c.penguin;

import java.io.*;
import java.util.*;

public class PenguinAnalyzer {

   private static final String FILE_NAME = "PalmerPenguins.csv";
   private List<PenguinData> penguinList;


   public void readPenguinData() {

       penguinList = new ArrayList<>();

       try (BufferedReader reader =
               new BufferedReader(new FileReader(FILE_NAME))) {

           String line;

           reader.readLine(); // skip header

           while ((line = reader.readLine()) != null) {

               String[] tokens = line.split(",");

               if (tokens.length >= 7) {

                   try {

                       int sampleNumber =
                           Integer.parseInt(tokens[0].trim());

                       String species = tokens[1].trim();

                       double billLength =
                           Double.parseDouble(tokens[2].trim());

                       double billDepth =
                           Double.parseDouble(tokens[3].trim());

                       double flipperLength =
                           Double.parseDouble(tokens[4].trim());

                       double bodyMass =
                           Double.parseDouble(tokens[5].trim());

                       String sex = tokens[6].trim();


                       penguinList.add(
                           new PenguinData(
                               sampleNumber,
                               species,
                               billLength,
                               billDepth,
                               flipperLength,
                               bodyMass,
                               sex));
                   }

                   catch (NumberFormatException e) {
                       System.err.println(
                           "Skipping invalid row: " + line);
                   }
               }
           }

       }
       
       catch (IOException e) {
           System.err.println(
               "Error reading file: " + e.getMessage());
       }
   }



   public void printPenguinData() {

       System.out.printf(
           "%-5s %-12s %-10s %-10s %-12s %-10s %-8s%n",
           "ID",
           "Species",
           "Bill Len",
           "Bill Dep",
           "Flipper Len",
           "Mass",
           "Sex");


       System.out.println(
           "------------------------------------------------------------");


       for (PenguinData penguin : penguinList) {

           System.out.printf(
               "%-5d %-12s %-10.1f %-10.1f %-12.1f %-10.1f %-8s%n",
               penguin.getSampleNumber(),
               penguin.getSpecies(),
               penguin.getBillLength(),
               penguin.getBillDepth(),
               penguin.getFlipperLength(),
               penguin.getBodyMass(),
               penguin.getSex());
       }
   }



   public void writePenguinData() {

       try (PrintWriter writer =
               new PrintWriter(
                   new FileWriter("PenguinOutput.txt"))) {


           writer.printf(
               "%-5s %-12s %-10s %-10s %-12s %-10s %-8s%n",
               "ID",
               "Species",
               "Bill Len",
               "Bill Dep",
               "Flipper Len",
               "Mass",
               "Sex");


           writer.println(
               "------------------------------------------------------------");


           for (PenguinData penguin : penguinList) {

               writer.printf(
                   "%-5d %-12s %-10.1f %-10.1f %-12.1f %-10.1f %-8s%n",
                   penguin.getSampleNumber(),
                   penguin.getSpecies(),
                   penguin.getBillLength(),
                   penguin.getBillDepth(),
                   penguin.getFlipperLength(),
                   penguin.getBodyMass(),
                   penguin.getSex());
           }


           System.out.println(
               "Penguin data written to PenguinOutput.txt.");

       }

       catch (IOException e) {

           System.err.println(
               "Error writing file: " + e.getMessage());
       }
   }
}