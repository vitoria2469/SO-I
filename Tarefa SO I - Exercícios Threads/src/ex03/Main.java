package ex03;

public class Main {

	public static void main(String[] args) {
		// Gerar vetor de 1000 posições com números aleatórios entre 1 e 100
		int[] vetor = new int[1000];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * 100) + 1;
		}

		// Criar e iniciar as duas threads
		ThreadVetor thread1 = new ThreadVetor(1, vetor); // Passa número ímpar
		ThreadVetor thread2 = new ThreadVetor(2, vetor); // Passa número par

		thread1.start();
		thread2.start();
	}
}

class ThreadVetor extends Thread {
	private int valor; // Valor numérico (1 ou 2)
	private int[] vet; // Vetor a ser percorrido

	// Construtor da classe
	public ThreadVetor(int valor, int[] vet) {
		this.valor = valor;
		this.vet = vet;
	}

	@Override
	public void run() {
		long startTime = System.nanoTime(); // Marca o tempo de início

		// Verificar se o número é par ou ímpar e percorrer o vetor de acordo
		if (valor % 2 == 0) { // Par - usar a estrutura for
			for (int i = 0; i < vet.length; i++) {
				// Simula algum processamento, como apenas acessar o valor
				int x = vet[i];
			}
		} else { // Ímpar - usar a estrutura foreach
			for (int num : vet) {
				// Simula algum processamento, como apenas acessar o valor
				int x = num;
			}
		}

		long endTime = System.nanoTime(); // Marca o tempo de término
		long duration = endTime - startTime; // Tempo em nanosegundos
		double durationInSeconds = duration / 1_000_000_000.0; // Converte para segundos

		System.out.println("Thread " + Thread.currentThread().getId() + " (Valor: " + valor + ") levou "
				+ durationInSeconds + " segundos para percorrer o vetor.");
	}

}