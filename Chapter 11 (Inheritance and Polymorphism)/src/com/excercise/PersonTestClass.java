package com.excercise;

import java.util.Date;

public class PersonTestClass {

	public static void main(String[] args) {
		
		Person person = new Person("Nabin Karki", "123456789", "naabin@outlook.com");
		
		Student student  =  new Student(1);
		student.setName("John Doe");
		student.setEmail("john@doe.email.com");
		student.setPhoneNumber("00001112223");
		Employee employee = new Employee(false, 10, new Date());
		
		Faculty faculty = new Faculty("7:00 - 15:00", "Sanitary Engineer");
		
		Staff staff = new Staff("Developer");
		
		System.out.println(person);
		
		System.out.println(student);
		
		System.out.println(employee);
		
		System.out.println(faculty);
		
		System.out.println(staff);
	}

}
