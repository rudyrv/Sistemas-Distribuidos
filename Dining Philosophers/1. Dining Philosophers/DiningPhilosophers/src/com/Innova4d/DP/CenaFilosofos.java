package com.Innova4d.DP;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CenaFilosofos {
	// El número de filósofos...
	private static final int NUM_FILOSOFOS = 5;

	/**
	 * Una prueba de los filósofos.
	 * @param args Not used
	 */
	public static void main (String[] args) {
		/*
		 *  Cada tenedor es un recurso compartido.
		 *  Los recursos compartidos en Java se definen como tipo Lock.
		 */
        ReentrantLock[] tenedores = new ReentrantLock[NUM_FILOSOFOS];

        Filosofo filosofo;
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
			tenedores[i] = new ReentrantLock();

		}
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            filosofo = new Filosofo(i, tenedores[i], tenedores[(i + 1) % NUM_FILOSOFOS]);
            new Thread(filosofo).start();
        }

	}

}
