package com.jin;

import java.util.ArrayList;
import java.util.List;

public class OutMemory {

    byte[] bte=new byte[1024*1024];
    public static void main(String[] args) {
        List list=new ArrayList();
        int count=0;
        try {
            while (true){
                list.add(new OutMemory());
                count++;
            }
        } catch (Error e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }
}
