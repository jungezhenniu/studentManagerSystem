package com.jgzn.redis.util;


import redis.clients.jedis.Jedis;

public class ConnectToRedis {
		
		private static Jedis jedis = null;
		
		private ConnectToRedis () {
		
		}
		
		public static Jedis getJedis() {
			if(jedis == null) {
				jedis = new Jedis();
				}
			
			return jedis;
			}
		
	}


