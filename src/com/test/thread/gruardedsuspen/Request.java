package com.test.thread.gruardedsuspen;

public class Request {

	private String name;
	
	public Request(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return "[Request"+this.name+"]";
	}
}
