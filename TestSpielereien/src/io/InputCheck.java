package io;

import java.util.Scanner;

public class InputCheck {

	private String meinePrivateVariable;
	public String meinePublicVariable;
	protected String meineProtectedVariable;
	String nochEineVariable;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Eingabe 1:");
		int text = sc.nextInt();
		System.out.println(text);
	}

}
