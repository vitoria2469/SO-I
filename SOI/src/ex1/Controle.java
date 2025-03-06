package ex1;

public class Controle {
	
	public void percorrerVetor(int tamanho) {
		int[] vetor = new int[tamanho]; // Cria um vetor de inteiros
		long inicio = System.nanoTime(); // Marca o tempo de início
		
		// Percorre o vetor
	    for (int i = 0; i < vetor.length; i++) {
	    	vetor[i] = 0; // Preenche o vetor com 0
	    }
	    
	    long fim = System.nanoTime(); // Marca o tempo de fim
	    double tempoGasto = (fim - inicio) / 1_000_000_000.0; // Converte para segundos
	    System.out.println("Tempo gasto para percorrer vetor de " + tamanho + " posições: " + tempoGasto + " segundos.");
	}
}