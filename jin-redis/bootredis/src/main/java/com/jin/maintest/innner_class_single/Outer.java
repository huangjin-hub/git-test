package com.jin.maintest.innner_class_single;

public class Outer {
    private Outer(){

    }
    public static Outer getInstance(){
        return inner.OUTER;
    }
    public static class inner{
       private static final Outer OUTER=new Outer();
    }
}
