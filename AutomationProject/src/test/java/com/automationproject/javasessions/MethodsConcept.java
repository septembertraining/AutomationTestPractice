package com.automationproject.javasessions;

public class MethodsConcept {
	
	public void addition() {
		int a= 13300;
		int b= 14300;
		 int c=a+b;
		 System.out.println(c);
	}
	
	public void addition2(int a, int b) {
		int c=a+b;
		
		System.out.println("Addition of two numbers :: "+c);
	}
	
	public void subtraction(int a, int b) {
		 int c= a-b;
		 System.out.println("Subtraction of two numbers is ::"+c);
	}
	
	public void division(int a, int b) {
		int c= a/b;
		System.out.println("Division of two numbers is :: "+c);
	}
	
	public static void main(String[] args) {
		
		//[ClassName] [reference]= new [ClassName]();
		
		MethodsConcept  methods= new MethodsConcept();
		
		methods.addition();
		methods.addition2(1200, 2537);
		methods.subtraction(2344, 12456);
		
		methods.division(1200, 100);
	}

}

// Now my requirement is to add diff --13300 +14300
