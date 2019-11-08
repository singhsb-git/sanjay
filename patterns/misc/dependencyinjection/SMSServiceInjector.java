package com.san.patterns.misc.dependencyinjection;

import com.san.patterns.misc.dependencyinjection.Consumer;
import com.san.patterns.misc.dependencyinjection.MyDIApplication;
import com.san.patterns.misc.dependencyinjection.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}
