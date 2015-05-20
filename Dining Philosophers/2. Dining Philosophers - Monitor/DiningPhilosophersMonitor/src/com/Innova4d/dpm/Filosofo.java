package com.Innova4d.dpm;
import java.util.Random;


public class Filosofo implements Runnable {
	// Genera un número aleatorio para cuanto tiempo come un filósofo.
	private Random numGenerator = new Random();

	// El id único de cada filósofo.
	private int id;

	// Un monitor que controla los recursos.
	private Monitor monitor;

	/**
	 * Constructor para el filósofo
	 * @param id el id único
	 * @param monitor el que controla los recursos
	 */
	public Filosofo (int id, Monitor monitor) {
		this.id = id;
		this.monitor = monitor;
	}

	/**
	 * Piensa, come y baja cubiertos.
	 */
	public void run() {
		try {
			while (true) {
				piensa();
				monitor.levantaCubiertos(id);
				come();
				monitor.bajarCubiertos(id);
			}
		} catch (InterruptedException e) {
			System.out.println("Filósofo: " + id + " interrumpido.\n");
		}
	}

	/**
	 * Permite que el filósofo piense por un tiempo aleatorio
	 * @throws InterruptedException
	 */
	private void piensa() throws InterruptedException {
		System.out.println("Filósofo " + id + " está pensando.\n");
		Thread.sleep (numGenerator.nextInt(10));
	}

	/**
	 * Permite que el filósofo coma por un tiempo aleatorio.
	 * @throws InterruptedException
	 */
	private void come() throws InterruptedException {
        System.out.println("El filósofo " + id + " está comiendo.\n" );
		Thread.sleep(numGenerator.nextInt(10));
	}
}
