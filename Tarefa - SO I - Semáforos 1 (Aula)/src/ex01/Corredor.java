package ex01;

import java.util.Random;

public class Corredor {

	Cavaleiro[] cavaleiros;
	Random rand = new Random();

	public Corredor(Cavaleiro[] cavaleiros) {
		this.cavaleiros = cavaleiros;
	}

	public void iniciarCaminhada() {
		int tempo = 50;

		while (true) {
			for (Cavaleiro cavaleiro : cavaleiros) {
				cavaleiro.caminhar(tempo);
				cavaleiro.verificarTocha();
				cavaleiro.verificarPedra();
				if (cavaleiro.chegouAoFinal()) {
					System.out.println(cavaleiro.nome + " chegou ao final do corredor!");
					return;
				}
			}
		}
	}

	public void escolherPortas() {

		int portaCorreta = rand.nextInt(4) + 1;
		System.out.println("A porta correta é a número " + portaCorreta);

		for (Cavaleiro cavaleiro : cavaleiros) {
			int portaEscolhida = rand.nextInt(4) + 1;
			System.out.println(cavaleiro.nome + " escolheu a porta " + portaEscolhida);

			if (portaEscolhida == portaCorreta) {
				System.out.println(cavaleiro.nome + " encontrou a saída!");
			} else {
				System.out.println(cavaleiro.nome + " foi devorado por um monstro!");
			}
		}
	}

}
