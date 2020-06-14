package com.jin.maintest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"a",21));
        users.add(new User(2,"b",22));
        users.add(new User(3,"c",23));
        users.add(new User(4,"d",24));
        users.add(new User(5,"e",25));
        users.add(new User(6,"f",26));
        users.add(new User(7,"g",27));

       /* users.stream().filter(a->a.getId()%2==0)
                .filter(a->a.getAge()>=23)
                .map(a->{return a.getName().toUpperCase();})
                .sorted((a,b)->{
                   return -a.compareTo(b);
        }).limit(1).forEach((s)-> {
            System.out.println(s);});*/

        users.stream().filter(a->a.getId()%2==0)
                .filter(a->a.getAge()>=23)
                .map(a->{return a.getName().toUpperCase();})
                .sorted((a,b)->{
                    return -a.compareTo(b);
                }).limit(1).forEach(System.out::println);
    }
}
