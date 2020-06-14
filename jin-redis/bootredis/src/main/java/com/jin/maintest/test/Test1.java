package com.jin.maintest.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= 1000000000) ? 1000000000 : n + 1;
    }

    public static void main(String[] args) {

        //System.out.println(tableSizeFor(16));
        int sum1=0;
        int sum2=0;
        for (int i = 1; i < 1000; i++) {
            sum1+=i;
            sum2=0;
            for (int j = i+2; j < 1000; j++) {
                sum2+=j;
                if (sum1==sum2){
                    for (int k = 1; k <= i; k++) {
                        System.out.print(""+k);
                    }
                    for (int n = i+2; n <= j; n++) {
                        String str=""+n;
                        System.out.print("\n"+str);
                    }
                }
            }
        }
    }
}
