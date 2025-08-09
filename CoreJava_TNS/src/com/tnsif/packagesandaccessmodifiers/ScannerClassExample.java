package com.tnsif.packagesandaccessmodifiers;

import java.util.Scanner;

public class ScannerClassExample {
	
	

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter College Name: ");
		String cname = s.next();
		
		
		System.out.println("Enter Couselling Code: ");
		int code = s.nextInt();
		
		System.out.println("The College name is: " + cname +", The College code is: "+code);

	}

}
