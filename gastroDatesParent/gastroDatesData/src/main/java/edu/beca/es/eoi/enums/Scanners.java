package edu.beca.es.eoi.enums;

import java.util.Scanner;

import lombok.Getter;

@Getter
public enum Scanners {
	ESCANERENTEROS(new Scanner(System.in)), ESCANERSTRINGS(new Scanner(System.in)),
	ESCANERDOUBLES(new Scanner(System.in));

	private Scanner scanner;

	Scanners(Scanner scanner) {
	}

	public int nextInt() {
		return ESCANERENTEROS.nextInt();
	}

	public String nextLine() {
		return ESCANERSTRINGS.nextLine();
	}

	public double nextDouble() {
		return ESCANERDOUBLES.nextDouble();
	}
}