package org.example.filters;

public class SouvenirFilter {

    private String nameFilter;
    private String manufacturerFilter;
    private String countryFilter;
    private int releaseYearFilter;
    private double minPriceFilter;
    private double maxPriceFilter;

/*    public SouvenirFilter(String nameFilter, String manufacturerFilter, String countryFilter, int releaseYearFilter, double minPriceFilter, double maxPriceFilter) {
        this.nameFilter = nameFilter;
        this.manufacturerFilter = manufacturerFilter;
        this.countryFilter = countryFilter;
        this.releaseYearFilter = releaseYearFilter;
        this.minPriceFilter = minPriceFilter;
        this.maxPriceFilter = maxPriceFilter;
    }*/


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
