package com.example.demo;

import java.io.*;

public class FileReaderTestClass {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\text.txt");

        try(FileReader fileReader = new FileReader(file);) {
        if(fileReader.ready()){
            int charFromBuffer = 0;
            while ((charFromBuffer = fileReader.read() ) != -1){
                System.out.println((char) charFromBuffer);
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File reading completed.");

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("writing");
        fileWriter. flush();
//        fileWriter.close();
//        Writer p = fileWriter.append('p');

    }
}
