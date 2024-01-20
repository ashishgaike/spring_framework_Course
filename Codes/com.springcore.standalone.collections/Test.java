package com.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext con = new ClassPathXmlApplicationContext(
				"com/springcore/standalone/collections/aloneconfig.xml");
		Person person1 = con.getBean("person1", Person.class);
		System.out.println(person1);
		System.out.println(person1.getFriends().getClass().getName());
		System.out.println("____________________________________________");
		System.out.println(person1.getFeesstructure());
		System.out.println(person1.getFeesstructure().getClass());
		System.out.println("____________________________________________");
		System.out.println(person1.getProperties());

	}

}
