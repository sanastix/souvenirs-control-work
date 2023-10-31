package org.example.filters;

public class ManufacturerFilter {

    private String nameFilter;
    private String countryFilter;
    private double minPriceFilter;
    private double maxPriceFilter;

/*    public ManufacturerFilter(String nameFilter, String countryFilter, double minPriceFilter, double maxPriceFilter) {
        this.nameFilter = nameFilter;
        this.countryFilter = countryFilter;
        this.minPriceFilter = minPriceFilter;
        this.maxPriceFilter = maxPriceFilter;
    }*/

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
