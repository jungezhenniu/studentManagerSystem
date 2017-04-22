package com.jgzn.redis.test;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.jgzn.redis.util.ConnectToRedis;

public class ConnTest {
	
	
	
	@Test
	public void getAll() {
			
			Jedis jedis = new Jedis("localhost");
			Set<String> keys = jedis.keys("student*");
			 Iterator t1=keys.iterator() ;   
	         while(t1.hasNext()){   
	             Object obj1=t1.next();   
	             System.out.println(obj1);  
	         }
			
		}
	}
