package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistroController {

	// Método privado para identificar o Sistema Operacional
	private String os() {
		return System.getProperty("os.name").toLowerCase();
	}

	// Método para exibir as informações sobre a distribuição Linux
	public void exibeDistro() {
		String os = os();

		// Verifica se o sistema operacional é Linux
		if (os.contains("linux")) {
			ProcessBuilder processBuilder = new ProcessBuilder("cat", "/etc/os-release");

			try {
				Process process = processBuilder.start();
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				// Exibe as informações sobre a distribuição Linux
				System.out.println("Informações sobre a distribuição Linux:");
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				process.waitFor();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			// Caso o sistema não seja Linux
			System.out.println("Este sistema não é Linux.");
		}
	}
}