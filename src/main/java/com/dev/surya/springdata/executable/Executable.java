package com.dev.surya.springdata.executable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.dev.surya.springdata.bean.GemFireBean;
import com.dev.surya.springdata.data.Message;
import com.google.common.collect.Lists;

public class Executable {
	// Getting spring context
	public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new ClassPathResource("SpringContext.xml").getPath());

	// GemFireBean declaration, it's just a normal spring bean
	public static GemFireBean gfb;


	public static void main(String[] args) {
		// Acquiring the GemFireBean
		gfb = (GemFireBean)context.getBean("gemFireBean");

		System.out.println("Before Linking GemFire ... Initialized Message Objects");
		Message mess1 = new Message("1","Hello World!");
		Message mess2 = new Message("2","Hello Spring Data!");
		Message mess3 = new Message("3","Hello Spring Data - GemFire !");
		Message mess4 = new Message("4","Just Hello !");

		// Add messages to List
		List<Message> messages = new ArrayList<Message>();
		messages.add(mess1);
		messages.add(mess2);
		messages.add(mess3);
		messages.add(mess4);

		System.out.println("Print out all Created Messages");
		for(Message m : messages){
			System.out.println("Created Message ID :: "+m.getMessageId()+" :: With Content :: "+m.getMessage());
		}

		System.out.println("Persisting Messages");
		gfb.getMessageRepository().save(messages);

		System.out.println("Persisting Messages Completed");
		// Reset the messages list
		messages = null;

		System.out.println("Retrieving Messages");
		messages = Lists.newArrayList(gfb.getMessageRepository().findAll());
		for(Message m : messages){
			System.out.println("Retrieved Message ID :: "+m.getMessageId()+" :: With Content :: "+m.getMessage());
		}

		System.out.println("End Of Execution");
	}
}