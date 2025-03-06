package ex1;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controle cont = new Controle();
		
		// Testa com diferentes tamanhos de vetor
		cont.percorrerVetor(1000);
		cont.percorrerVetor(10000);
		cont.percorrerVetor(100000);
	}
}