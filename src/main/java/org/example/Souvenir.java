package org.example;

public class Souvenir {

    private int id;
    private String name;
    private Manufacturer manufacturer;
    private int releaseDate;
    private double price;

    public Souvenir(int id, String name, Manufacturer manufacturer, int releaseDate, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }
}
