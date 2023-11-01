package org.example.filters;

import org.example.menu.Menu;

import javax.swing.table.DefaultTableModel;

public class SouvenirFilter {

    private final Menu menu = new Menu();
    private String nameFilter;
    private String manufacturerFilter;
    private String countryFilter;
    private int releaseYearFilter;
    private double minPriceFilter;
    private double maxPriceFilter;

    public void filter(){
        DefaultTableModel newModel = new DefaultTableModel();

        //initialize parameters
        //iterate through database
        //add to model if not null parameters equals



        menu.showResultTable(newModel, "Filtered table");
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    public String getManufacturerFilter() {
        return manufacturerFilter;
    }

    public void setManufacturerFilter(String manufacturerFilter) {
        this.manufacturerFilter = manufacturerFilter;
    }

    public String getCountryFilter() {
        return countryFilter;
    }

    public void setCountryFilter(String countryFilter) {
        this.countryFilter = countryFilter;
    }

    public int getReleaseYearFilter() {
        return releaseYearFilter;
    }

    public void setReleaseYearFilter(int releaseYearFilter) {
        this.releaseYearFilter = releaseYearFilter;
    }

    public double getMinPriceFilter() {
        return minPriceFilter;
    }

    public void setMinPriceFilter(double minPriceFilter) {
        this.minPriceFilter = minPriceFilter;
    }

    public double getMaxPriceFilter() {
        return maxPriceFilter;
    }

    public void setMaxPriceFilter(double maxPriceFilter) {
        this.maxPriceFilter = maxPriceFilter;
    }


}
