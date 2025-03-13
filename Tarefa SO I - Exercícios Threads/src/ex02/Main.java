package ex02;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// Definir as dimensões da matriz
		int linhas = 3;
		int colunas = 5;

		// Criar a matriz 3x5
		int[][] matriz = new int[linhas][colunas];

		// Preencher a matriz com números aleatórios entre 1 e 100
		Random random = new Random();
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = random.nextInt(100) + 1; // Números entre 1 e 100
			}
		}

		// Exibir a matriz gerada
		System.out.println("Matriz gerada:");
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		// Criar e iniciar as 3 threads
		for (int i = 0; i < linhas; i++) {
			final int linha = i; // A linha que a thread vai processar
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					// Calcular a soma da linha
					int soma = 0;
					for (int j = 0; j < colunas; j++) {
						soma += matriz[linha][j];
					}
					// Imprimir o ID da Thread (TID) e a soma da linha
					long threadId = Thread.currentThread().getId(); // TID
					System.out.println("Thread ID: " + threadId + " | Linha " + (linha + 1) + " soma: " + soma);
				}
			});
			thread.start(); // Inicia a execução da thread
		}
	}

}