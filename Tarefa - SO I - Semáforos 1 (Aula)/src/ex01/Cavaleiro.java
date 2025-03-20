package ex01;

public class Cavaleiro {

	String nome;
	int distanciaPercorrida = 0;
	int velocidade;
	boolean temTocha = false;
	boolean temPedra = false;

	public Cavaleiro(String nome, int velocidade) {
	        this.nome = nome;
	        this.velocidade = velocidade;
	    }


	public void aumentarVelocidade() {
		this.velocidade += 2;
	}


	public void caminhar(int tempo) {
		distanciaPercorrida += velocidade * tempo / 50;
	}


	public void verificarTocha() {
		if (distanciaPercorrida >= 500 && !temTocha) {
			temTocha = true;
			aumentarVelocidade();
			System.out.println(nome + " pegou a tocha! Velocidade aumentada!");
		}
	}


	public void verificarPedra() {
		if (distanciaPercorrida >= 1500 && !temPedra && temTocha) {
			temPedra = true;
			aumentarVelocidade();
			System.out.println(nome + " pegou a pedra brilhante! Velocidade aumentada!");
		}
	}


	public boolean chegouAoFinal() {
		return distanciaPercorrida >= 2000;
	}
}
