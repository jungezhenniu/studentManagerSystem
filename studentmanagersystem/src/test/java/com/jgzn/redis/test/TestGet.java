package com.jgzn.redis.test;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestGet {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		Set<String> keys = jedis.keys("*");
		 Iterator<String> t1=keys.iterator() ;   
        while(t1.hasNext()){   
            Object obj1=t1.next();   
            System.out.println(obj1);  
        }
	}
}
