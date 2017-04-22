package com.jgzn.redis.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import redis.clients.jedis.Jedis;
import com.jgzn.redis.service.StudentService;
import com.jgzn.redis.util.ConnectToRedis;
import com.jgzn.redis.util.GetAllKey;

public class StudentServiceImpl implements StudentService{

	GetAllKey getAllKey = new GetAllKey();
	Iterator<String> keys = null;
	private Jedis jedis = ConnectToRedis.getJedis();
	
	@Override
	public Iterator<String> getAll() {
		//该方法就已经得到了所有的student的key，这个keys是iterator型
		//得到的结果是所有的key,就是student01,student02,保存在iterator
		keys = getAllKey.getAllKey();
		return keys;
         }   

	@Override
	public void update(String id,String name,String avgscore,String description,String birthday) {
		//思路：因为id又是这个学生的key，所以通过这个id，我们能找到这个学生
		if(id!=null&&id.length()>0) {
			jedis.hset(id,"name",name);
			jedis.hset(id,"avgscore",avgscore);
			jedis.hset(id,"description",description);
			jedis.hset(id,"birthday",birthday);
		}
	}

	@Override
	public void delete(String id) {
		jedis.del(id);
	}
	
	@Override
	public void add(String id,String name,String avgscore,String description,String birthday) {
			//判断一下：如果该id已经存在，那么不能向里存
		 	Map<String, String> map = new HashMap<String, String>();   
	        map.put("name", name);  
	        map.put("avgscore", avgscore);
	        map.put("description", description);
	        map.put("birthday", birthday);//存进来是String类型，而且应该是yyyy-MM-dd形式，这里不用转类型了
	        //因为这里没有跟对象打交道。提交表单是提交的String类型，redis中保存的也是String，所以没有转类型。
	        //把birthda直接放进map容器中，
	        jedis.hmset(id, map); 			
	}
}
