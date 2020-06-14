package com.jin.utils;

import java.util.Arrays;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        String str="编写一段代码，找出下面文字中有几处不一致的地方（假设字数一致，连续的文字错误算一项，此处应有3处不同，简述代码或设计思路";
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
