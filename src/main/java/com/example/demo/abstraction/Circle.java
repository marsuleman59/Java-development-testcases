package com.example.demo.abstraction;

class classs
{
    public void callMe(){
        System.out.println("classA");
    }
}

class classB extends classs
{
    public void callMe(){
        System.out.println("classB");
    }
}

class classC extends classB
{
    public void callMe(){
        System.out.println("classc");
    }

    public static void main(String[] args) {
    classs a1 = new classs();
        classC classC = (classC) a1;
    }
}



public class Circle extends Shape {

    Circle(int a, int b) {
        super(a, b);
    }

    public Circle() {
        super();
    }

    public static void main(String[] args) {
        Shape shape = new Circle();

        String str = "A";
        switch (str) {
            case "a":
                System.out.println("a");
            default:
                System.out.println("def");
            case "A":
                System.out.println("A");

        }
    }
}
