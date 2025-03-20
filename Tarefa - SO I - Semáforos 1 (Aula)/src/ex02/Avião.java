package ex02;

import java.util.Random;

public class Avi�o implements Runnable {
	private final String nome;
	private final Aeroporto aeroporto;
	private final Random rand = new Random();
	private final String pista;

	public Avi�o(String nome, Aeroporto aeroporto) {
		this.nome = nome;
		this.aeroporto = aeroporto;
		this.pista = rand.nextBoolean() ? "Norte" : "Sul";
	}

	public String getNome() {
		return nome;
	}

	public void realizarFase(String fase, int tempoMin, int tempoMax) throws InterruptedException {
		int tempo = rand.nextInt(tempoMax - tempoMin + 1) + tempoMin;
		System.out.println(nome + " est� na fase de " + fase + " por " + tempo + " milissegundos.");
		Thread.sleep(tempo);
	}

	@Override
	public void run() {
		try {
			System.out.println(nome + " est� se preparando para decolar na pista " + pista);
			aeroporto.decolar(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
