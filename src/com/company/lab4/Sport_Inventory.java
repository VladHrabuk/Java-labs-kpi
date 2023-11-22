package com.company.lab4;

public class Sport_Inventory {
    private final String name_of_balls;
    private final int quantity_of_balls;
    private final String name_of_dumbbells;
    private final int quantity_of_dumbbells;
    private final String name_of_institution;

    public Sport_Inventory(String name_of_balls, int quantity_of_balls, String name_of_dumbbells,
                           int quantity_of_barbells, String name_of_institution) {
        this.name_of_balls = name_of_balls;  // Producer of balls
        this.quantity_of_balls = quantity_of_balls;
        this.name_of_dumbbells = name_of_dumbbells;  //Producer of dumbbells
        this.quantity_of_dumbbells = quantity_of_barbells;
        this.name_of_institution = name_of_institution; //The name of the institution, that needs this inventory
    }

    public String getName_of_balls() {
        return name_of_balls;
    }

    public int getQuantity_of_balls() {
        return quantity_of_balls;
    }

    public String getName_of_dumbbells() {
        return name_of_dumbbells;
    }

    public int getQuantity_of_dumbbells() {
        return quantity_of_dumbbells;
    }

    public String getName_of_institution() {
        return name_of_institution;
    }
}
