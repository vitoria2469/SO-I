package ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CorridaDeSapos {

	public static void main(String[] args) {
		int distanciaMaxima = 100; // Distância máxima para a corrida (em metros)
		int tamanhoMaximoSalto = 10; // Tamanho máximo de cada salto (em metros)

		// Lista para armazenar os sapos que completaram a corrida
		List<String> colocacao = new ArrayList<>();

		// Criar e iniciar 5 sapos (threads)
		Thread sapo1 = new Thread(new Sapo("Sapo 1", distanciaMaxima, tamanhoMaximoSalto, colocacao));
		Thread sapo2 = new Thread(new Sapo("Sapo 2", distanciaMaxima, tamanhoMaximoSalto, colocacao));
		Thread sapo3 = new Thread(new Sapo("Sapo 3", distanciaMaxima, tamanhoMaximoSalto, colocacao));
		Thread sapo4 = new Thread(new Sapo("Sapo 4", distanciaMaxima, tamanhoMaximoSalto, colocacao));
		Thread sapo5 = new Thread(new Sapo("Sapo 5", distanciaMaxima, tamanhoMaximoSalto, colocacao));

		// Iniciar as threads (corrida)
		sapo1.start();
		sapo2.start();
		sapo3.start();
		sapo4.start();
		sapo5.start();

		// Esperar as threads terminarem a corrida
		try {
			sapo1.join();
			sapo2.join();
			sapo3.join();
			sapo4.join();
			sapo5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Exibir a ordem de chegada dos sapos
		System.out.println("\nResultado da Corrida:");
		for (int i = 0; i < colocacao.size(); i++) {
			System.out.println((i + 1) + "º lugar: " + colocacao.get(i));
		}
	}
}

class Sapo implements Runnable {
	private String nome;
	private int distanciaMaxima;
	private int tamanhoMaximoSalto;
	private List<String> colocacao;
	private Random random;

	public Sapo(String nome, int distanciaMaxima, int tamanhoMaximoSalto, List<String> colocacao) {
		this.nome = nome;
		this.distanciaMaxima = distanciaMaxima;
		this.tamanhoMaximoSalto = tamanhoMaximoSalto;
		this.colocacao = colocacao;
		this.random = new Random();
	}

	@Override
	public void run() {
		int distanciaPercorrida = 0;

		while (distanciaPercorrida < distanciaMaxima) {
			// O sapo faz um salto aleatório
			int salto = random.nextInt(tamanhoMaximoSalto) + 1; // Salto entre 1 e tamanhoMaximoSalto
			distanciaPercorrida += salto;

			// Evitar ultrapassar a distância máxima
			if (distanciaPercorrida > distanciaMaxima) {
				distanciaPercorrida = distanciaMaxima;
			}

			// Mostrar o salto e a distância percorrida
			System.out.println(
					nome + " deu um salto de " + salto + " metros, totalizando " + distanciaPercorrida + " metros.");

			// Pausar para dar uma sensação de corrida
			try {
				Thread.sleep(500); // Atraso de 500ms entre os saltos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Quando o sapo chegar na linha de chegada
		synchronized (colocacao) {
			colocacao.add(nome); // Adiciona o sapo na lista de chegada
			System.out.println(nome + " chegou na linha de chegada e ficou em " + (colocacao.size()) + "º lugar!");
		}
	}

}
