package com.example.demo.abstraction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Shape {

    private int a ;
    private int b;

//    {
//        System.out.println("empty init block");
//    }
//
//    static {
//        System.out.println("static 1 block");
//    }
//
//    static {
//        System.out.println("static 2 block");
//    }

    private String name;

    Shape(){

    }

    Shape(int a, int b){
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {

        Shape shape = new Shape();
        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
        LocalDate localDate1 = localDate.plusDays(1);
//        System.out.println(localDate1);

        String[] [] strArray = {{"A","B","C"}, {"D","E"}};
        System.out.println(Arrays.toString(strArray));
        System.out.println(" strArray = {{\"A\",\"B\",\"C\"}, {\"D\",\"E\"}}::: "+strArray.length);

        System.out.println("Length of 1st array:: " + strArray[0].length);
        System.out.println("Length of 2nd array:: " + strArray[1].length);


//        for (int i = 0; i < strArray.length; i++) {
//            for (int j = 0; j < strArray[i].length; j++) {
//                System.out.println("strArray["+i+"]["+j+"] "+strArray[i][j] );
//                if(strArray[i][j].equals("A")){
//                    break;
//                }
//            }
//        }

        String str = " ";

        System.out.println(str.isEmpty());

    }
}
