package com.data.hashmap;

import java.util.HashMap;

public class Data {
	
	public HashMap<String, String> getUserLoginInfo(){
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("customer", "naveenk_test@123");
		userMap.put("admin", "adminuser_test@123");
		return userMap;
		
	}
	
	public HashMap<Integer, String> monthMap(){
		HashMap<Integer, String> monthMap = new HashMap<Integer, String>();
		monthMap.put(1, "Jan");
		monthMap.put(2, "Feb");
		monthMap.put(3, "Mar");
		monthMap.put(4, "April");
		monthMap.put(5, "May");
		monthMap.put(6, "Jun");
		monthMap.put(7, "Jul");
		monthMap.put(8, "Aug");
		return monthMap;
		
	}

}
