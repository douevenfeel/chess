package com.douevenfeel.game;

public enum Color {
    WHITE, BLACK;

    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }

    public String getSymbol() {
        return this == WHITE ? "w" : "b";
    }
}
