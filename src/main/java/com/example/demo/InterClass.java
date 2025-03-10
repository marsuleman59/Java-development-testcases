package com.example.demo;

import java.io.FileNotFoundException;

public interface InterClass {
    public void export() throws FileNotFoundException;

    static void export(int a) {

    }
}
