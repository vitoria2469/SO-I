package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main2 {
	public static void main(String[] args) {
		while (true) {
			// Exibe uma janela com opções de escolha para o usuário
			String option = JOptionPane.showInputDialog("Escolha uma opção:\n" + "1 - Listar Processos\n"
					+ "2 - Matar Processo por PID\n" + "3 - Matar Processo por Nome\n" + "4 - Sair");

			if (option == null || option.equals("4")) {
				// Se o usuário escolher '4' ou cancelar a janela, o programa sai
				JOptionPane.showMessageDialog(null, "Aplicação encerrada.");
				break;
			}

			// Instancia a classe KillController para manipular as operações
			KillController controller = new KillController();

			switch (option) {
			case "1":
				// Chama o método para listar os processos
				controller.listaProcessos();
				break;
			case "2":
				// Solicita o PID e chama o método para matar o processo por PID
				String pid = JOptionPane.showInputDialog("Digite o PID do processo a ser finalizado:");
				controller.mataPid(pid);
				break;
			case "3":
				// Solicita o nome do processo e chama o método para matar o processo pelo nome
				String nome = JOptionPane.showInputDialog("Digite o nome do processo a ser finalizado:");
				controller.mataNome(nome);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
			}
		}
	}
}