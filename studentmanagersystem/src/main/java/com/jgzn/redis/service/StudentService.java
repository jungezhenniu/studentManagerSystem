package com.jgzn.redis.service;

import java.util.Iterator;

public interface StudentService {
	public Iterator<String> getAll();
	public void update(String id,String name,String avgscore,String description,String birthday);
	public void delete(String id);
	public void add(String id,String name,String avgscore,String description,String birthday);
}
