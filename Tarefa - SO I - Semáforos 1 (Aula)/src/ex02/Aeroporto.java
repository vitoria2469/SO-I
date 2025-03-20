package ex02;

import java.util.concurrent.Semaphore;

public class Aeroporto {

	private final Semaphore semaforo = new Semaphore(2);

	public void decolar(Avião avião) throws InterruptedException {
		semaforo.acquire();

		try {
			System.out.println(avião.getNome() + " começando a decolagem.");
			avião.realizarFase("Taxiar", 500, 1000);
			avião.realizarFase("Manobra", 300, 700);
			avião.realizarFase("Decolagem", 600, 800);
			avião.realizarFase("Afastamento", 300, 800);
			System.out.println(avião.getNome() + " decolou com sucesso.");
		} finally {
			semaforo.release();
		}
	}
}