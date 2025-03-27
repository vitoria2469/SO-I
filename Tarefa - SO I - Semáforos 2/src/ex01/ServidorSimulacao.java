package ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorSimulacao {

	// Classe que representa as threads
	static class RequisicaoThread extends Thread {
		private final int id;

		public RequisicaoThread(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				// Simulando o comportamento da thread com base no ID
				if (id % 3 == 1) {
					// Threads com ID % 3 == 1
					realizarTransacoesTipo1();
				} else if (id % 3 == 2) {
					// Threads com ID % 3 == 2
					realizarTransacoesTipo2();
				} else {
					// Threads com ID % 3 == 0
					realizarTransacoesTipo3();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void realizarTransacoesTipo1() throws InterruptedException {
			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 800 + 200)); // Cálculos entre 0,2 e 1,0 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1000); // Transação de BD por 1 segundo

			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 800 + 200)); // Cálculos entre 0,2 e 1,0 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1000); // Transação de BD por 1 segundo
		}

		private void realizarTransacoesTipo2() throws InterruptedException {
			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 1000 + 500)); // Cálculos entre 0,5 e 1,5 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1500); // Transação de BD por 1,5 segundos

			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 1000 + 500)); // Cálculos entre 0,5 e 1,5 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1500); // Transação de BD por 1,5 segundos

			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 1000 + 500)); // Cálculos entre 0,5 e 1,5 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1500); // Transação de BD por 1,5 segundos
		}

		private void realizarTransacoesTipo3() throws InterruptedException {
			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 1000 + 1000)); // Cálculos entre 1,0 e 2,0 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1500); // Transação de BD por 1,5 segundos

			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 1000 + 1000)); // Cálculos entre 1,0 e 2,0 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1500); // Transação de BD por 1,5 segundos

			System.out.println("Thread " + id + " iniciando cálculos...");
			Thread.sleep((long) (Math.random() * 1000 + 1000)); // Cálculos entre 1,0 e 2,0 segundos

			System.out.println("Thread " + id + " realizando transação de BD...");
			Thread.sleep(1500); // Transação de BD por 1,5 segundos
		}
	}

	public static void main(String[] args) {
		// Usando ExecutorService para gerenciar um conjunto de threads
		ExecutorService executor = Executors.newFixedThreadPool(21);

		// Criando e iniciando 21 threads
		for (int i = 1; i <= 21; i++) {
			executor.submit(new RequisicaoThread(i));
		}

		// Aguardando a conclusão de todas as threads
		executor.shutdown();
	}
}