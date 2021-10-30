package com.example.demo.generics;

public class WaterMelon extends Melon {
    private int a;

    public WaterMelon(int a) {
        super(a);
        this.a = a;
    }

    @Override
    public int getA() {
        return a;
    }

    @Override
    public void setA(int a) {
        this.a = a;
    }
}
