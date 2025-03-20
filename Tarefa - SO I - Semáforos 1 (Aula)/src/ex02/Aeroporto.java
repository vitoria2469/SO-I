package ex02;

import java.util.concurrent.Semaphore;

public class Aeroporto {

	private final Semaphore semaforo = new Semaphore(2);

	public void decolar(Avi�o avi�o) throws InterruptedException {
		semaforo.acquire();

		try {
			System.out.println(avi�o.getNome() + " come�ando a decolagem.");
			avi�o.realizarFase("Taxiar", 500, 1000);
			avi�o.realizarFase("Manobra", 300, 700);
			avi�o.realizarFase("Decolagem", 600, 800);
			avi�o.realizarFase("Afastamento", 300, 800);
			System.out.println(avi�o.getNome() + " decolou com sucesso.");
		} finally {
			semaforo.release();
		}
	}
}