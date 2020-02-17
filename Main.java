package com.tam.yathzee;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		YathzeeSpel nieuwSpel = new YathzeeSpel();
		Dobbelsteen nieuwDob = new Dobbelsteen();
		Worp nieuwWorp = new Worp();
		
		System.out.println("Eerste Worp: "+Arrays.toString(nieuwSpel.dobbelstenen));
		
		while (true) {
		
		System.out.println("Resultaat na worp: "+Arrays.toString(nieuwSpel.dobbelstenen));
			
		System.out.println("Welke posities wilt u vasthouden, 0 voor geen anders bv 124: ");

		String invoerVasthouden = sc.nextLine();

		nieuwDob.vasthouden(invoerVasthouden);
		
		nieuwWorp.werp(nieuwSpel.dobbelstenen, nieuwDob.eenOfTwee);
		}
		

//		System.out.println("BEURT2: Welke posities wilt u vasthouden, 0 voor geen anders bv 124: ");
//
//		String invoerVasthouden2 = sc.nextLine();
//		
//		nieuwDob.vasthouden(invoerVasthouden2);
//		
//		nieuwWorp.werp(nieuwSpel.dobbelstenen, nieuwDob.eenOfTwee);

	}

}

class YathzeeSpel {

	Scanner sc = new Scanner(System.in);
	public int[] dobbelstenen = new int[5];

	public YathzeeSpel() {

		
		for (int i = 0; i < dobbelstenen.length; i++) {
			dobbelstenen[i] = werpen();
			// System.out.println(dobbelstenen[i]);

		}

	}

	void printDobbelstenen() {
		System.out.println("Random gooi :" + Arrays.toString(dobbelstenen));

	}

	void Spelen() {

		while (true) {

			System.out.println("Druk Enter om te spelen en Q om te stoppen");
			String letter = sc.nextLine();

			if (letter.toUpperCase().equals("")) {
				// System.out.println("test");
				// System.out.println(werpen());

			}

			else if (letter.toUpperCase().equals("Q")) {
				System.out.println("Bedankt voor het spelen");
				return;

			}

			else {
				System.out.println("Voer goede letter in");
			}
		}
	}

	public static int werpen() {
		Random random = new Random();
		int a = random.nextInt(6);
		a++;
		return a;

	}
}

class Dobbelsteen {

	Scanner sc = new Scanner(System.in);
	public static int[] eenOfTwee = new int[5];
	String[] vastHouden = new String[5];
	List<String> tempList = Arrays.asList(vastHouden);

	void vasthouden(String a) {
		for (int i = 0; i < a.length(); i++) {
			vastHouden[i] = "" + a.charAt(i);
		}

		System.out.println("Begin status 1/0: "+Arrays.toString(eenOfTwee));
		System.out.println("Welke invoer: "+Arrays.toString(vastHouden));

		if (tempList.contains("1")) {
			eenOfTwee[0] = 1;
		}
		if (tempList.contains("2")) {
			eenOfTwee[1] = 1;
		}
		if (tempList.contains("3")) {
			eenOfTwee[2] = 1;
		}
		if (tempList.contains("4")) {
			eenOfTwee[3] = 1;
		}
		if (tempList.contains("5")) {
			eenOfTwee[4] = 1;
		}

		System.out.println("Invoer op 1/0: "+Arrays.toString(eenOfTwee));
	}

}

class Worp {
		
	void werp(int[] a, int[] b){
			
			
			System.out.println("Eerste Worp Parameter(a): "+Arrays.toString(a));
			System.out.println("1/0 Parameter(b): "+Arrays.toString(b));
			
			for(int f = 0; f < b.length ; f++) {
				if(b[f] == 0) {
					a[f] = YathzeeSpel.werpen();
					} 
				Dobbelsteen.eenOfTwee[f]=0;
				
				
			}
			System.out.println("Nieuwe uitkomst worp: "+Arrays.toString(a));
			System.out.println("Nieuwe uitkomst 1/0: "+Arrays.toString(b));
			
			
			
		}
}
