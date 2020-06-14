package com.jin;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("94.191.18.28",6379);
        System.out.println(jedis.select(0));
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.type("name"));
        System.out.println(jedis.dbSize());
        System.out.println(jedis.keys("*"));

    }
}
