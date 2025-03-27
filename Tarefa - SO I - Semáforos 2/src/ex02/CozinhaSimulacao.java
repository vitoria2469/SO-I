package ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CozinhaSimulacao {

	static class PratoCozinhando extends Thread {
		private final int id;
		private final String nome;
		private final double tempoCozimento; // Tempo total de cozimento em segundos

		public PratoCozinhando(int id) {
			this.id = id;
			if (id % 2 == 1) { // Prato ímpar
				this.nome = "Sopa de Cebola";
				this.tempoCozimento = Math.random() * 0.3 + 0.5; // Entre 0,5 e 0,8 segundos
			} else { // Prato par
				this.nome = "Lasanha à Bolonhesa";
				this.tempoCozimento = Math.random() * 0.6 + 0.6; // Entre 0,6 e 1,2 segundos
			}
		}

		@Override
		public void run() {
			try {
				System.out.println("Iniciando o cozimento do prato " + id + ": " + nome);

				// A cada 0,1 segundos, exibe o progresso do cozimento
				int passos = (int) (tempoCozimento / 0.1); // Quantos passos de 0,1 segundos o prato levará
				for (int i = 1; i <= passos; i++) {
					Thread.sleep(100); // Atraso de 0,1 segundo
					double progresso = (i * 0.1) / tempoCozimento * 100;
					System.out.println("Prato " + id + " (" + nome + ") - Cozimento: " + (int) progresso + "%");
				}

				// O prato está pronto agora
				System.out.println("Prato " + id + " (" + nome + ") está pronto!");

				// Simula a entrega do prato, levando 0,5 segundos
				Thread.sleep(500);
				System.out.println("Prato " + id + " (" + nome + ") entregue!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// ExecutorService para gerenciar 5 threads
		ExecutorService executor = Executors.newFixedThreadPool(5);

		// Criando e iniciando 5 pratos
		for (int i = 1; i <= 5; i++) {
			executor.submit(new PratoCozinhando(i));
		}

		// Aguardando a conclusão de todas as threads
		executor.shutdown();
	}
}
