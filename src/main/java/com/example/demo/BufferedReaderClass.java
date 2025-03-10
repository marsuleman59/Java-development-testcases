package com.example.demo;

import java.io.*;
import java.util.stream.Stream;

public class BufferedReaderClass {
    public static void main(String[] args) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new StringReader("111222333444555"));


        // FIle readers are good for char reading
        File file = new File("sdfs");
        FileReader  fileReader = new FileReader(file);
        fileReader.read();
        fileReader.close();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

        FileInputStream  fileInputStream = new FileInputStream(file);

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream  objectOutputStream = new ObjectOutputStream(null);





        int ch ;


    }
}
