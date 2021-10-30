package com.example.demo.standalone;

public class StringConstPool {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("s1 hashcode: "+s1.hashCode());
        System.out.println("s2 hashcode: "+s2.hashCode());
        System.out.println("s3 hashcode: "+s3.hashCode());
        System.out.println("s4 hashcode: "+s4.hashCode());

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s4==s1);

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        String a = "Java";
        String b = "Java";
        System.out.println(a == b);
        System.out.println("a hashcode: "+a.hashCode());
        System.out.println("b hashcode: "+b.hashCode());

    }

}
