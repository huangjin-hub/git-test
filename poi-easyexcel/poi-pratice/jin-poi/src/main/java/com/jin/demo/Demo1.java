package com.jin.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        InputStream resourceAsStream = Demo1.class.getResourceAsStream("/product.properties");
        prop.load(resourceAsStream);
        String url = prop.getProperty("url");
        System.out.println(url);

    }
}
