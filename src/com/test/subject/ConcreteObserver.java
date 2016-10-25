package com.test.subject;

public class ConcreteObserver implements IObserver {

	@Override
	public void update(Event evn) {
		evn.doSubscribe();
	}

}
