package com.java.student.model;

public enum Grade {
    A_PLUS("A+"),
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F");

    private final String label;

    Grade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
