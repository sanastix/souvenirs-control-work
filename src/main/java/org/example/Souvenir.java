package org.example;

public class Souvenir {

    private int id;
    private String name;
    private String manufacturerDetails;
    private int releaseDate;
    private double price;

    public Souvenir(int id, String name, String manufacturerDetails, int releaseDate, double price) {
        this.id = id;
        this.name = name;
        this.manufacturerDetails = manufacturerDetails;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturerDetails() {
        return manufacturerDetails;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }
}
