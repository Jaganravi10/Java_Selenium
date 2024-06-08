package java_selenium;

import java.util.Arrays;

public class GetterAndSetterExample1 {

	public static void main(String[] args) {

		GetterAndSetterExample example = new GetterAndSetterExample();
		example.setFirstName("Jagan");
		example.setLastName("Ravi");
		example.setEmail("java@oracle.com");
		example.setSkills(Arrays.asList("Java","Selenium","API"));
		
		System.out.println(example.getFirstName());
		System.out.println(example.getLastName());
		System.out.println(example.getEmail());
		System.out.println(example.getSkills());

		
	}

}
