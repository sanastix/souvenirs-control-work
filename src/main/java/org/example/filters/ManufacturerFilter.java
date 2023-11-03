package org.example.filters;

import org.example.FileParser;
import org.example.menu.Menu;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Objects;

public class ManufacturerFilter extends Filter {

    private final FileParser parser = new FileParser(menu);

    public ManufacturerFilter(Menu menu) {
        super(menu);
    }

    @Override
    public void filter() {
        DefaultTableModel newModel = new DefaultTableModel();
        Object[] column = parser.manufacturerColumnNames;
        newModel.setColumnIdentifiers(column);

        String nameFilter = menu.getManufacturerName();
        String countryFilter = menu.getMCountryOfBox();

        double minPriceFilter = 0;
        double maxPriceFilter = 0;

        if (menu.getMinMPrice() != null && !menu.getMinMPrice().isEmpty()) {
            try {
                minPriceFilter = Double.parseDouble(menu.getMinMPrice());
            } catch (Exception e){
                menu.displayErrorMessage("Incorrect input");
            }
        }
        if (menu.getMaxMPrice() != null && !menu.getMaxMPrice().isEmpty()) {
            try {
                maxPriceFilter = Double.parseDouble(menu.getMaxMPrice());
            } catch (Exception e){
                menu.displayErrorMessage("Incorrect input");
            }
        }

        List<String> manufacturersBase = parser.readManufacturersBase().stream().sorted().toList();
        List<String> souvenirsBase = parser.readSouvenirsBase().stream().sorted().toList();
        Object[] row;
        if (!manufacturersBase.isEmpty()){
            for (String manufacturer : manufacturersBase){
                String[] manufacturerParts = manufacturer.split(":");

                double price = 0;

                String name = manufacturerParts[1];
                String country = manufacturerParts[2];
                double maxPrice = Double.MIN_VALUE;
                double minPrice = Double.MAX_VALUE;

                for (String s : souvenirsBase){
                    String[] sParts = s.split(":");
                    if (sParts[2].equals(name)){
                        price = Double.parseDouble(sParts[4]);
                        if (price > maxPrice) {
                            maxPrice = price;
                        }
                        if (price < minPrice) {
                            minPrice = price;
                        }
                    }
                }

                boolean passFilters = true;

                if (nameFilter != null && !name.equals(nameFilter)){
                    passFilters = false;
                } else if (countryFilter != null && !Objects.equals(country,countryFilter)){
                    passFilters = false;
                } else if ((minPriceFilter != 0 && price < minPriceFilter) || (maxPriceFilter != 0 && price > maxPriceFilter)) {
                    passFilters = false;
                }

                if (passFilters){
                    row = manufacturerParts;
                    newModel.addRow(row);
                }
            }
        }
        menu.showResultTable(newModel, "Filtered table");
    }

}
