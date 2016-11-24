package com.test.thread.master_worker;

import com.test.thread.master_worker.framework.Worker;

public class PlusWork extends Worker {

	@Override
	public Object handle(Object input) {
		Integer i = (Integer) input;
		return i*i*i;
	}
}
