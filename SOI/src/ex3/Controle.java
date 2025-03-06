package ex3;

public class Controle {
	
	public void processarVetor(int[] vetor) {
		System.out.println("Resultados:");
		for (int numero : vetor) {
			if (numero % 2 != 0) {
				// Número ímpar
				System.out.println(numero + " é ímpar.");
	        } else {
	        	// Número par
	        	if (numero % 10 == 0) {
	        		System.out.println(numero + " é par e múltiplo de 10.");
	            }
	        }
	    }
	}
}