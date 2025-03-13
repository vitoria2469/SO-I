package ex01;

public class Main {
	
	public static void main(String[] args) {
		// Criando e iniciando 5 threads
	    for (int i = 0; i < 5; i++) {
	    	Thread thread = new Thread(new Runnable() {
	    		@Override
	    		public void run() {
	    			// Obtendo o ID da Thread (para JDK até 18 use getId(), para versões posteriores use threadId())
	                long id = Thread.currentThread().getId(); // Para JDK até 18
	                // Para JDK posteriores, descomente a linha abaixo:
	                // long id = Thread.currentThread().threadId(); // Para JDK 19 ou superior

	                System.out.println("Thread TID: " + id);
	            }
	        });
	    	thread.start();  // Inicia a thread
	    }
	}
}