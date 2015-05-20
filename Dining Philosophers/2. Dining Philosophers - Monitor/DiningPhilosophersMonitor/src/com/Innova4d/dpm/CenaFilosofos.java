package com.Innova4d.dpm;


public class CenaFilosofos {
	// Número de filósofos
	private static final int num_filosofos = 5;

	public static void main (String[] args) {
		Filosofo[] filosofos = new Filosofo[num_filosofos];
		// El monitor controla la asignación de recursos compartidos.
        Monitor monitor = new Monitor(num_filosofos);
		for (int i = 0; i < num_filosofos; i++) {
			filosofos[i] = new Filosofo(i, monitor);
			new Thread(filosofos[i]).start();
		}
	}
}
