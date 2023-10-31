package org.example.filters;

import java.util.ArrayList;
import java.util.List;

public class DataFilter {

    public List<List<String>> filterSouvenirs(List<List<String>> souvenirsBase, SouvenirFilter souvenirFilter) {
        List<List<String>> filteredSouvenirs = new ArrayList<>();

        for (List<String> souvenir : souvenirsBase) {
            String name = souvenir.get(1);
            String manufacturer = souvenir.get(2);
            int releaseYear = Integer.parseInt(souvenir.get(3));
            double price = Double.parseDouble(souvenir.get(4));

            if (name.contains(souvenirFilter.getNameFilter()) &&
                    manufacturer.equals(souvenirFilter.getManufacturerFilter()) &&
                    releaseYear >= souvenirFilter.getReleaseYearFilter() &&
                    price >= souvenirFilter.getMinPriceFilter() &&
                    price <= souvenirFilter.getMaxPriceFilter()) {
                filteredSouvenirs.add(souvenir);
            }
        }

        return filteredSouvenirs;
    }

    public List<List<String>> filterManufacturers(List<List<String>> manufacturersBase, ManufacturerFilter manufacturerFilter) {
        List<List<String>> filteredManufacturers = new ArrayList<>();

        for (List<String> manufacturer : manufacturersBase) {
            String name = manufacturer.get(1);
            String country = manufacturer.get(2);
            double price = Double.parseDouble(manufacturer.get(3));

            if (name.contains(manufacturerFilter.getNameFilter()) &&
                    country.equals(manufacturerFilter.getCountryFilter()) &&
                    price >= manufacturerFilter.getMinPriceFilter() &&
                    price <= manufacturerFilter.getMaxPriceFilter()) {
                filteredManufacturers.add(manufacturer);
            }
        }

        return filteredManufacturers;
    }

}
