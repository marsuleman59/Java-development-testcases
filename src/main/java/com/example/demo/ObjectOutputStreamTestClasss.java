package com.example.demo;

import java.io.*;

public class ObjectOutputStreamTestClasss {

    public static void main(String[] args) throws IOException {
        Employee employee = new Employee();
        employee.setID("1111");
        employee.setName("Suleman");

        File file = new File("F:\\text.txt");
        FileOutputStream  fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.flush();
        objectOutputStream.close();

        try (
                FileInputStream fileInputStream = new FileInputStream(new File("F:\\text.txt"));
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            Employee employeeExtracted = (Employee) objectInputStream.readObject();
            System.out.println("employeeExtracted ::: " + employeeExtracted);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
