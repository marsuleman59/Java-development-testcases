package com.example.demo;

import java.io.IOException;
import java.util.Arrays;

public class InterClassImpl implements InterClass{
    @Override
    public void export() throws ClassCastException{

    }

    static void export(int a) {

    }

    public static void main(String[] args) {
//        InterClassImpl.StaticInnerClass innerClass = new StaticInnerClass();
//        innerClass.ad();
//        InterClassImpl.StaticInnerClass.ad();
//        InterClassImpl.export(1);

        System.out.println(Arrays.toString(Level. values()));

    }

    static class StaticInnerClass{
        public static void ad(){
            System.out.println("printed static method of inner class");
        }

    }


    public enum Level{
        LOW(1),
        MEDIUM(2),
        HIGH(3);

        private final int levelNumber;
        Level(int levelNumber){
            this.levelNumber = levelNumber;
        }
    }
}
