package com.example.demo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassTest {
    public static void main(String[] args) {
        Path path1 = Paths.get("a/C/");
        Path path2 = Paths.get("a/C/b");

        System.out.println("Path1 resolve path2: " + path1.resolve(path2));
        System.out.println("Path1 resolve path2: " + path1.relativize(path2));


    }
}
