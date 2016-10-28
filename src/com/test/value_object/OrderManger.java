package com.test.value_object;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderManger extends UnicastRemoteObject implements IOrderManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4806670918461778866L;

	protected OrderManger() throws RemoteException {
		super();
	}

	@Override
	public String getClientName(int id) throws RemoteException {
		return "billy";
	}

	@Override
	public String getProdName(int id) throws RemoteException {
		return "desk";
	}

	@Override
	public int getNumber(int id) throws RemoteException {
		return 20;
	}

	@Override
	public Order getOrder(int id) throws RemoteException {
		Order order = new Order();
		order.setClientName("billy");
		order.setNumber(20);
		order.setProductName("desk");
		return order;
	}

}
