package com.test.proxy;

public class TestMain {

	public static void main(String args[]){
		IDBQuery idbQuery = new DBQueryProxy();
		System.out.println(idbQuery.request());
	}
}
