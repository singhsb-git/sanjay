package com.san.patterns.misc.dependencyinjection;

import com.san.patterns.misc.dependencyinjection.Consumer;
import com.san.patterns.misc.dependencyinjection.MyDIApplication;
import com.san.patterns.misc.dependencyinjection.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new EmailServiceImpl());
	}

}