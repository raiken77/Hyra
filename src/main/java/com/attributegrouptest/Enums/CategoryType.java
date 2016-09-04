package com.attributegrouptest.Enums;

/**
 * Created by Noobs on 04/09/2016.
 */
public enum CategoryType {
    LAPTOP("Laptop chargers"),
    ARDUINO("Arduino Kits"),
    BOOKS("Books"),
    CALCULATOR("Calculators"),
    CABLES("Cables and Connectors");


    private final String name;

    private CategoryType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return otherName!=null && name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
