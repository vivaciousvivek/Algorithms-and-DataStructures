package com.techfirebase.daa.utils.constants;

public enum VisitingColor {
    RED('R'), GREEN('G'), BLACK('B');

    private char color;

    VisitingColor(char color) {
        this.color = color;
    }

    public char getChar() {
        return color;
    }
}
