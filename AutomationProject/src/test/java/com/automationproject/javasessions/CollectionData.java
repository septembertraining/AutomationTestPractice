package com.automationproject.javasessions;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionData {
	
	public static void main(String[] args) {
		
		ArrayList<String> students = new ArrayList<String>();
		
		students.add("Ram");
		students.add("Rahim");
		students.add("Robert");
		students.add("Sham");
		students.add("Ram");
		
		// In this method duplicates allowed
		
		//How to print arraylist
		
		System.out.println(students);
		
		//Arraylist accepts duplicates, and insertion order is preserved.
		
		//[Ram, Rahim, Robert, Sham, Ram]
		
		HashSet<String> employees= new HashSet<String>();
		
		employees.add("Chiranjeevi");
		employees.add("Balakrishna");
		employees.add("Nagarjuna");
		employees.add("Chiranjeevi");
		employees.add("Venkatesh");
		
		System.out.println(employees);
		//[Chiranjeevi, Balakrishna, Venkatesh, Nagarjuna]
	}

}
