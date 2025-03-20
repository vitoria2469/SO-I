package ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Aeroporto aeroporto = new Aeroporto();
		ExecutorService executor = Executors.newFixedThreadPool(12);

		for (int i = 1; i <= 12; i++) {
			executor.submit(new Avião("Avião " + i, aeroporto));
		}

		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	}

}
