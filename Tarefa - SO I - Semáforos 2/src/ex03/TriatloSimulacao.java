package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TriatloSimulacao {

	// Classe que representa o atleta
	static class Atleta implements Comparable<Atleta> {
		int id;
		double tempoCorrida;
		double tempoTiros;
		double tempoCiclismo;
		int pontosTiros;
		int posicaoCorrida;
		int pontosRanking;

		public Atleta(int id) {
			this.id = id;
			// A posição inicial é de 0 e os pontos do ranking ainda não existem
			this.pontosTiros = 0;
		}

		// Método para calcular o tempo de corrida de cada atleta
		public void calcularTempoCorrida() {
			double velocidade = 20 + Math.random() * 5; // entre 20 e 25 m/30s
			this.tempoCorrida = (3000 / velocidade) * 30; // 3 km = 3000 metros
		}

		// Método para simular os tiros (tempo e pontuação)
		public void calcularTiros() throws InterruptedException {
			this.tempoTiros = 0;
			for (int i = 0; i < 3; i++) {
				// Cada tiro leva entre 0,5 e 3 segundos
				double tempoTiro = 0.5 + Math.random() * 2.5;
				this.tempoTiros += tempoTiro;
				this.pontosTiros += (int) (Math.random() * 11); // Pontuação do tiro entre 0 e 10
				Thread.sleep((long) (tempoTiro * 1000)); // Simula o tempo do tiro (em segundos)
			}
		}

		// Método para calcular o tempo de ciclismo
		public void calcularTempoCiclismo() {
			double velocidade = 30 + Math.random() * 10; // entre 30 e 40 m/40s
			this.tempoCiclismo = (5000 / velocidade) * 40; // 5 km = 5000 metros
		}

		// Método para calcular a pontuação no ranking baseado na posição da corrida
		public void calcularRanking(int posicao) {
			this.posicaoCorrida = posicao;
			// O primeiro recebe 250 pontos, o segundo 240, e assim por diante
			this.pontosRanking = 250 - (posicao - 1) * 10 + pontosTiros;
		}

		@Override
		public int compareTo(Atleta outro) {
			// Ordena os atletas pela pontuação final (decrescente)
			return Integer.compare(outro.pontosRanking, this.pontosRanking);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Executor para simular a execução paralela
		ExecutorService executor = Executors.newFixedThreadPool(5);

		// Lista para armazenar os atletas
		List<Atleta> atletas = new ArrayList<>();

		// Criando 25 atletas
		for (int i = 1; i <= 25; i++) {
			atletas.add(new Atleta(i));
		}

		// Calcular o tempo de corrida para cada atleta (em ordem)
		for (Atleta atleta : atletas) {
			atleta.calcularTempoCorrida();
		}

		// Ordenar atletas pela ordem de chegada na corrida (menor tempo é o primeiro)
		atletas.sort(Comparator.comparingDouble(a -> a.tempoCorrida));

		// Simular o processo de tiros (somente 5 armas)
		Semaphore armasDisponiveis = new Semaphore(5); // 5 armas
		for (Atleta atleta : atletas) {
			armasDisponiveis.acquire(); // Espera por uma arma
			executor.submit(() -> {
				try {
					atleta.calcularTiros(); // Calcula o tempo de tiros
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					armasDisponiveis.release(); // Libera a arma
				}
			});
		}

		// Espera até todos os atletas terminarem os tiros
		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

		// Calcular o tempo de ciclismo para todos os atletas
		for (Atleta atleta : atletas) {
			atleta.calcularTempoCiclismo();
		}

		// Calcular o ranking baseado na posição na corrida
		for (int i = 0; i < atletas.size(); i++) {
			atletas.get(i).calcularRanking(i + 1);
		}

		// Ordenar os atletas pela pontuação final (ranking)
		Collections.sort(atletas);

		// Exibir o resultado final
		System.out.println("Resultado final do Triatlo:");
		for (Atleta atleta : atletas) {
			System.out.println("Atleta " + atleta.id + " - Pontuação Final: " + atleta.pontosRanking);
		}
	}
}
