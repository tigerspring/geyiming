package com.test.value_object;

import java.rmi.Naming;

public class TestMain {
	public static void main(String[] args) {
		try {
			IOrderManager usermanager = (IOrderManager) Naming.lookup("OrderManger");
			long begin = System.currentTimeMillis();
			for(int i = 0 ; i < 1000 ; i++){
				usermanager.getOrder(i);
			}
			System.out.println("getorder spend:"+(System.currentTimeMillis()-begin));
			
			begin = System.currentTimeMillis();
			for(int i = 0 ; i < 1000 ; i++){
				usermanager.getClientName(i);
				usermanager.getNumber(i);
				usermanager.getProdName(i);
			}
			System.out.println("3method call spend:"+(System.currentTimeMillis()-begin));
			
			System.out.println(usermanager.getOrder(0).getClientName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
