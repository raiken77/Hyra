package com.attributegrouptest.Enums;

/**
 * Created by Noobs on 04/09/2016.
 */
public enum ItemCondition {
    NEW("New"),
    OLD("Old"),
    USED("Used");

    private final String name;

    private ItemCondition(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return otherName!=null && name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
