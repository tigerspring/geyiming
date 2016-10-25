package com.test.subject;

public class Event {
	
	private String informStr = "";
	
	public Event(String str){
		informStr = str;
	}

	public void doSubscribe(){
		System.out.println(informStr);
	}
}
