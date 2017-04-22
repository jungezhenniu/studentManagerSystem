package com.jgzn.redis.util;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

//因为感觉后面的类几乎都要用到这个key，所以先把它抽离出来
public class GetAllKey {
	private Jedis jedis = null;
	
	public Iterator<String> getAllKey() {
		
		jedis = ConnectToRedis.getJedis();
		Set<String> keys = jedis.keys("0*");
		Iterator<String> t1=keys.iterator() ;   
		return t1;
	}
}
