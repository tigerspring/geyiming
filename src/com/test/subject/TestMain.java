package com.test.subject;

public class TestMain {

	public static void main(String[] args) {
		
		IObserver observer = new ConcreteObserver();
		
		ISubject subject = new ConcreteSubject();
		
		subject.attach(observer);
		
		subject.inform();
		
		
	}
}
