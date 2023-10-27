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

    public List<String> readSouvenirsBase(){
        List<String> souvenirsBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(souvenirsDB))) {
            String line;
            while ((line = br.readLine()) != null){
                souvenirsBase.add(line);
            }
        } catch (IOException e){
            menu.displayErrorMessage("Error in reading souvenirs file");
        }

        return souvenirsBase;
    }

    public List<List<String>> readSplittedSouvenirsBase (){
        List<List<String>> splittedSouvenirsBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(souvenirsDB))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                List<String> innerList = new ArrayList<>(Arrays.asList(parts));
                splittedSouvenirsBase.add(new ArrayList<>(innerList));
            }
        } catch (IOException e) {
            menu.displayErrorMessage("Error in reading souvenirs file");
        }

        return splittedSouvenirsBase;
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

    public List<ArrayList<String>> readManufacturersBase (){
        List<ArrayList<String>> manufacturersBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(manufacturersDB))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                List<String> innerList = new ArrayList<>(Arrays.asList(parts));
                manufacturersBase.add(new ArrayList<>(innerList));
            }
        } catch (IOException e) {
            menu.displayErrorMessage("Error in reading manufacturers file");
        }

        return manufacturersBase;
    }

}
