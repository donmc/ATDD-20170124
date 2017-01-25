package com.tddair;


public class Email {
	
	public static void validateEmail(String email) {

		 if(email.contains("@")) {
			 return;
		 }
		 else {
			 throw new InvalidEmailException();
		 }
	}

}
