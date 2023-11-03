package org.example;

import org.example.menu.Menu;
import java.io.*;
import java.util.*;

public class FileParser {

    private final String SOUVENIRS_DB = "Souvenirs.txt";
    private final File souvenirsDB = new File(SOUVENIRS_DB);
    public final String[] souvenirColumnNames = new String[]{"id", "name", "manufacturer's name", "release year", "price"};

    private final String MANUFACTURERS_DB = "Manufacturers.txt";
    private final File manufacturersDB = new File(MANUFACTURERS_DB);
    public final String[] manufacturerColumnNames = new String[]{"id", "name", "country"};

    public final String[] databaseColumnNames = new String[]{"№", "souvenir", "manufacturer", "country", "release date", "price"};

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

    public List<String> readSouvenirsBase() {
        List<String> souvenirBase = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(souvenirsDB))) {
            String line;
            while ((line = br.readLine()) != null){
                souvenirBase.add(line);
            }
        } catch (IOException e){
            menu.displayErrorMessage("Error in reading souvenirs file");
        }
        return souvenirBase;
    }

    public void writeSplitSouvenirsBase(List<List<String>> souvenirsBase){
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

    public void writeSouvenirsBase(List<String> souvenirsBase) {
        try(FileWriter fileWriter = new FileWriter(souvenirsDB);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String s : souvenirsBase) {
                bufferedWriter.write(s);
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

    public List<String> readManufacturersBase() {
        List<String> manufacturersBase = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(manufacturersDB))) {
            String line;
            while ((line = br.readLine()) != null){
                manufacturersBase.add(line);
            }
        } catch (IOException e){
            menu.displayErrorMessage("Error in reading manufacturers file");
        }
        return manufacturersBase;
    }

    public void writeSplitManufacturersBase(List<List<String>> manufacturersBase) {
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

    public void writeManufacturerBase(List<String> manufacturerBase){
        try(FileWriter fileWriter = new FileWriter(manufacturersDB);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String s : manufacturerBase) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            menu.displayErrorMessage("Error in writing manufacturers file");
        }
    }

    public Set<String> manufacturerNamesList(){
        Set<String> namesList = new HashSet<>();
        for (List<String> manufacturer : readSplitManufacturersBase()){
            namesList.add(manufacturer.get(1));
        }
        return namesList;
    }

    public Set<String> countryList(){
        Set<String> countryList = new HashSet<>();
        for (List<String> manufacturer : readSplitManufacturersBase()){
            countryList.add(manufacturer.get(2));
        }
        return countryList;
    }

    public Set<String> releaseYearList(){
        Set<String> yearsList = new HashSet<>();
        for (List<String> souvenir : readSplitSouvenirsBase()){
            yearsList.add(souvenir.get(3));
        }
        return yearsList;
    }
}
