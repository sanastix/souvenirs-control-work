package org.example.filters;

import org.example.menu.Menu;

import javax.swing.table.DefaultTableModel;

public class ManufacturerFilter {

    private final Menu menu = new Menu();
    private String nameFilter;

    private String countryFilter;
    private double minPriceFilter;
    private double maxPriceFilter;

    public void filter() {
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

    public String getCountryFilter() {
        return countryFilter;
    }

    public void setCountryFilter(String countryFilter) {
        this.countryFilter = countryFilter;
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
