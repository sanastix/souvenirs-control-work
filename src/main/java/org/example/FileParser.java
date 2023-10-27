package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {

    private final String SOUVENIRS_DB = "Souvenirs.txt";
    private final File souvenirsDB = new File(SOUVENIRS_DB);

    private final String MANUFACTURERS_DB = "Manufacturers.txt";
    private final File manufacturersDB = new File(MANUFACTURERS_DB);

    private final Menu menu;

    public FileParser(Menu menu) {
        this.menu = menu;
    }

    public List<List<String>> readSplitSouvenirsBase(){
        List<List<String>> splitSouvenirsBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(souvenirsDB))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                List<String> innerList = new ArrayList<>(Arrays.asList(parts));
                splitSouvenirsBase.add(new ArrayList<>(innerList));
            }
        } catch (IOException e) {
            menu.displayErrorMessage("Error in reading souvenirs file");
        }

        return splitSouvenirsBase;
    }

    public void writeSouvenirsBase(List<List<String>> souvenirsBase){
        try(FileWriter fileWriter = new FileWriter(souvenirsDB);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (List<String> innerList : souvenirsBase) {
                String joinedString = String.join(":", innerList);
                bufferedWriter.write(joinedString);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            menu.displayErrorMessage("Error in writing souvenirs file");
        }
    }

    public List<List<String>> readSplitManufacturersBase() {
        List<List<String>> splitManufacturersBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(manufacturersDB))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                List<String> innerList = new ArrayList<>(Arrays.asList(parts));
                splitManufacturersBase.add(new ArrayList<>(innerList));
            }
        } catch (IOException e) {
            menu.displayErrorMessage("Error in reading manufacturers file");
        }

        return splitManufacturersBase;
    }

    public void writeManufacturersBase(List<List<String>> manufacturersBase) {
        try(FileWriter fileWriter = new FileWriter(manufacturersDB);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (List<String> innerList : manufacturersBase) {
                String joinedString = String.join(":", innerList);
                bufferedWriter.write(joinedString);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            menu.displayErrorMessage("Error in writing manufacturers file");
        }
    }
}