package ex2;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Criar uma instância da classe de controle
		Controle controle = new Controle();

		// Solicitar ao usuário que insira um texto
		String texto = JOptionPane.showInputDialog("Digite um texto separado por ';':");
		String texto1 = JOptionPane.showInputDialog("Digite um texto separado por ';':");
		String texto2 = JOptionPane.showInputDialog("Digite um texto separado por ';':");

		// Contar as partes do texto
		int quantidadePartes = controle.contarPartes(texto);
		int quantidadePartes1 = controle.contarPartes(texto1);
		int quantidadePartes2 = controle.contarPartes(texto2);

		// Exibir a quantidade de partes
		System.out.println("O texto contém " + quantidadePartes + " partes.");
		System.out.println("O texto contém " + quantidadePartes1 + " partes.");
		System.out.println("O texto contém " + quantidadePartes2 + " partes.");
	}
}