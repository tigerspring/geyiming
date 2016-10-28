package com.test.value_object;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class OrderMangerServer {

	public static void main(String args[]){
		try {
			LocateRegistry.createRegistry(1099);
			IOrderManager usermanager = new OrderManger();
			Naming.rebind("OrderManger", usermanager);
			System.out.println("OrderManger is ready.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
