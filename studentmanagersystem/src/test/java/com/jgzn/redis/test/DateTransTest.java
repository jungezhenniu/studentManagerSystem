package com.jgzn.redis.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTransTest {
	public static void main(String[] args) throws ParseException {
		String s = "Tue Jul 12 00:00:00 GMT+08:00 2016";
        SimpleDateFormat sf1 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH); 
        Date date = sf1.parse(s);
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sf2.format(date));

	}
}
