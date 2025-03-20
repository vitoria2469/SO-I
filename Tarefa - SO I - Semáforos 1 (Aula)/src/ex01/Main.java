package ex01;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Cavaleiro[] cavaleiros = new Cavaleiro[4];
		cavaleiros[0] = new Cavaleiro("Cavaleiro 1", (new Random().nextInt(3) + 2));
		cavaleiros[1] = new Cavaleiro("Cavaleiro 2", (new Random().nextInt(3) + 2));
		cavaleiros[2] = new Cavaleiro("Cavaleiro 3", (new Random().nextInt(3) + 2));
		cavaleiros[3] = new Cavaleiro("Cavaleiro 4", (new Random().nextInt(3) + 2));

		Corredor corredor = new Corredor(cavaleiros);

		corredor.iniciarCaminhada();

		corredor.escolherPortas();
	}

}
