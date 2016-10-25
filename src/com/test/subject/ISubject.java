package com.test.subject;

public interface ISubject {

	void attach(IObserver observer);
	void detach(IObserver observer);
	void inform();
}
