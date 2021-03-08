package br.com.estudo.pix.ui;

import java.util.Scanner;

public class ui {

    public static String lerString(String text) {	
		Scanner entrada = new Scanner(System.in);
		String entradaString = entrada.nextLine();
		return entradaString;
	}

    public static Double lerDouble(String text) {	
		Scanner entrada = new Scanner(System.in);
		Double entradaDouble = entrada.nextDouble();
		return entradaDouble;
	}
    
}