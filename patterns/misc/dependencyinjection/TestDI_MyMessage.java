package com.san.patterns.misc.dependencyinjection;


/*
  As you can see that our application classes are responsible only for using the service. 
  Service classes are created in injectors. Also if we have to further extend our application
  to allow facebook messaging, we will have to write Service classes and injector classes only.
  So dependency injection implementation solved the problem with hard-coded dependency and helped
  us in making our application flexible and easy to extend. 
 */

import com.san.patterns.misc.dependencyinjection.Consumer;
import com.san.patterns.misc.dependencyinjection.EmailServiceInjector;
import com.san.patterns.misc.dependencyinjection.MessageServiceInjector;
import com.san.patterns.misc.dependencyinjection.SMSServiceInjector;


public class TestDI_MyMessage {

	public static void main(String[] args) {
		String msg = "Hi Pankaj";
		String email = "pankaj@abc.com";
		String phone = "4088888888";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}

}
