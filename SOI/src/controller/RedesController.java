package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController {

	// Método privado para identificar o Sistema Operacional
	private String os() {
		String os = System.getProperty("os.name").toLowerCase();
		return os;
	}

	// Método para exibir as configurações de IP
	public void ip() {
		String os = os();
		ProcessBuilder processBuilder;
		if (os.contains("win")) { // Windows
			processBuilder = new ProcessBuilder("ipconfig");
		} else { // Linux ou Mac
			processBuilder = new ProcessBuilder("ifconfig");
		}

		try {
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				// Filtrar e exibir apenas adaptadores com IPv4
				if (line.contains("IPv4") || line.contains("inet")) {
					System.out.println(line.trim());
				}
			}
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Método para realizar um ping e exibir o tempo médio
	public void ping() {
		String os = os();
		ProcessBuilder processBuilder;
		if (os.contains("win")) { // Windows
			processBuilder = new ProcessBuilder("ping", "-4", "-n", "10", "www.google.com.br");
		} else { // Linux ou Mac
			processBuilder = new ProcessBuilder("ping", "-4", "-c", "10", "www.google.com.br");
		}

		try {
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("média")) {
					// Filtra a linha que contém a média do ping
					String[] splitLine = line.split("média");
					System.out.println("Tempo médio do ping: " + splitLine[1].trim());
				}
			}
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}