package com.example.demo.standalone;

import java.io.IOException;

public class JavaExceptionTest {
    public static void main(String[] args) throws IOException {

        foo(1,0);

    }

    private static int foo(int i, int j) throws IOException {
        if (j == 0 ){
            throw new IOException("Exception for foo raised");
        }
        return i/0;
    }
}
