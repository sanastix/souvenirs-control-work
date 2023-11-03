package org.example.filters;

import org.example.FileParser;
import org.example.menu.Menu;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Objects;

public class SouvenirFilter extends Filter {

    private final FileParser parser = new FileParser(menu);

    public SouvenirFilter(Menu menu) {
        super(menu);
    }

    @Override
    public void filter() {
        DefaultTableModel newModel = new DefaultTableModel();
        Object[] column = parser.souvenirColumnNames;
        newModel.setColumnIdentifiers(column);

        String nameFilter = menu.getSouvenirName();
        String manufacturerFilter = menu.getManNameOfBox();
        String countryFilter = menu.getSCountryOfBox();

        int releaseYearFilter;
        double minPriceFilter;
        double maxPriceFilter;

        if (menu.getSYearOfBox() != null && !menu.getSYearOfBox().isEmpty()) {
            releaseYearFilter = Integer.parseInt(menu.getSYearOfBox());
        } else {
            releaseYearFilter = 0;
        }
        if (menu.getMinSPrice() != null && !menu.getMinSPrice().isEmpty()) {
            minPriceFilter = Double.parseDouble(menu.getMinSPrice());
        } else {
            minPriceFilter = 0;
        }
        if (menu.getMaxSPrice() != null && !menu.getMaxSPrice().isEmpty()) {
            maxPriceFilter = Double.parseDouble(menu.getMaxSPrice());
        } else {
            maxPriceFilter = 0;
        }

        List<String> souvenirsBase = parser.readSouvenirsBase().stream().sorted().toList();
        List<String> manufacturersBase = parser.readManufacturersBase().stream().sorted().toList();
        Object[] row;
        if (!souvenirsBase.isEmpty()){
            for (String souvenir : souvenirsBase) {
                String[] souvenirParts = souvenir.split(":");

                String name = souvenirParts[1];
                String manufacturer = souvenirParts[2];
                int releaseYear = Integer.parseInt(souvenirParts[3]);
                double price = Double.parseDouble(souvenirParts[4]);

                String country = null;
                for (String s : manufacturersBase){
                    String[] mParts = s.split(":");
                    if (countryFilter != null && manufacturer.equals(mParts[1]) && countryFilter.equals(mParts[2])){
                        country = mParts[2];
                        break;
                    }
                }

                boolean passFilters = true;

                if (nameFilter != null && !name.equals(nameFilter)) {
                    passFilters = false;
                } else if (manufacturerFilter != null && !manufacturer.equals(manufacturerFilter)) {
                    passFilters = false;
                } else if (countryFilter != null && !Objects.equals(country, countryFilter)){
                    passFilters = false;
                } else if (releaseYearFilter != 0 && releaseYear != releaseYearFilter) {
                    passFilters = false;
                } else if ((minPriceFilter != 0 && price < minPriceFilter) || (maxPriceFilter == 0 && price > maxPriceFilter)) {
                    passFilters = false;
                }

                if (passFilters) {
                    row = souvenirParts;
                    newModel.addRow(row);
                }
            }
        }
        menu.showResultTable(newModel, "Filtered table");

    }

}