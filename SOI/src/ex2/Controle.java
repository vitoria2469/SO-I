package ex2;

public class Controle {
	
	public int contarPartes(String texto) {
		// Dividir o texto usando o delimitador ';'
	    String[] partes = texto.split(";");
	    return partes.length; // Retornar a quantidade de partes
	}
}