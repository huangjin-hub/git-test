package com.jin.maintest;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainClass {

    public static void main(String[] args) {
        //函数型接口(只有一个方法的接口)
      Runnable runnable=()->{
          System.out.println();
      };
//断定型接口(返回值为boolean的接口)
        Predicate<String> stringPredicate = str ->{
            return str.isEmpty();
        };

//消费型接口(有参数但是没有返回值的接口)
        Consumer<String> consumer=s->{
            System.out.println(s);
        };
    }

    //供给性接口(没有参数但是有返回值的接口)
    Supplier<String> supplier=()->{
      return "123";
    };
}
