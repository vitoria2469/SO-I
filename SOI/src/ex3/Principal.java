package ex3;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor (máximo 100):"));
		        
		// Limitar o tamanho do vetor a 100
		if (n > 100) {
			n = 100;
		} else if (n <= 0) {
			JOptionPane.showMessageDialog(null, "O tamanho do vetor deve ser maior que 0.");
		    return;
		}

		int[] vetor = new int[n];

		// Coletar os valores do vetor
		for (int i = 0; i < n; i++) {
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor para a posição " + i + ":"));
		}

		// Criar uma instância da classe de controle e processar o vetor
		Controle controle = new Controle();
		controle.processarVetor(vetor);
	}

}