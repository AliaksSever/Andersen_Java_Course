package com.severin.interfaces;

public interface Printer {

    public default void print() {
        System.out.println("print content in console");
    }

}
