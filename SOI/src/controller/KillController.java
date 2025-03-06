package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillController {

	// Método privado para identificar o Sistema Operacional
	private String os() {
		String os = System.getProperty("os.name").toLowerCase();
		return os;
	}

	// Método para listar processos ativos de acordo com o sistema operacional
	public void listaProcessos() {
		String os = os();
		ProcessBuilder processBuilder;
		if (os.contains("win")) { // Windows
			processBuilder = new ProcessBuilder("tasklist", "/FO", "TABLE");
		} else { // Linux ou Mac
			processBuilder = new ProcessBuilder("ps", "-ef");
		}

		try {
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Método para matar um processo pelo PID
	public void mataPid(String pid) {
		String os = os();
		ProcessBuilder processBuilder;
		if (os.contains("win")) { // Windows
			processBuilder = new ProcessBuilder("taskkill", "/PID", pid);
		} else { // Linux ou Mac
			processBuilder = new ProcessBuilder("kill", "-9", pid);
		}

		try {
			Process process = processBuilder.start();
			process.waitFor();
			System.out.println("Processo com PID " + pid + " foi finalizado.");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Método para matar um processo pelo nome
	public void mataNome(String nome) {
		String os = os();
		ProcessBuilder processBuilder;
		if (os.contains("win")) { // Windows
			processBuilder = new ProcessBuilder("taskkill", "/IM", nome);
		} else { // Linux ou Mac
			processBuilder = new ProcessBuilder("pkill", "-f", nome);
		}

		try {
			Process process = processBuilder.start();
			process.waitFor();
			System.out.println("Processo " + nome + " foi finalizado.");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}