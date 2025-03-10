package com.example.demo.standalone;

abstract class Writer {
    public void write() {
        System.out.println("Writing...");
    }
}
class Author extends Writer {

    public void write() {
        System.out.println("Writing book");
    }
}
class Programmer extends Writer {
    public void write() {
        super.write();
        System.out.println("Writing code");
    }
    public static void main(String[] args) {
        Writer w = new Programmer();
        w.write();
    }
}
