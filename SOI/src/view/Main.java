package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		while (true) {
			// Exibe uma janela com opções de escolha para o usuário
			String option = JOptionPane.showInputDialog(
					"Escolha uma opção:\n" + "1 - Verificar IP\n" + "2 - Realizar Ping\n" + "3 - Sair");

			if (option == null || option.equals("3")) {
				// Se o usuário escolher '3' ou cancelar a janela, o programa sai
				JOptionPane.showMessageDialog(null, "Aplicação encerrada.");
				break;
			}

			// Instancia a classe RedesController para manipular as operações
			RedesController controller = new RedesController();

			switch (option) {
			case "1":
				// Chama o método para mostrar o IP
				controller.ip();
				break;
			case "2":
				// Chama o método para realizar o ping
				controller.ping();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
			}
		}
	}
}