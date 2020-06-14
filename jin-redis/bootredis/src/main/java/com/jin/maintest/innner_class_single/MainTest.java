package com.jin.maintest.innner_class_single;

public class MainTest {
    public static int fun(){
        try {
            int a=3/0;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }
}
