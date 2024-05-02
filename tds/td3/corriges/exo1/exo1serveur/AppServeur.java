package exo1serveur;

import java.io.IOException;

class AppServeur {
	private final static int PORT = 1234;

	public static void main(String[] args) {
		try {
			new Thread(new Serveur(PORT)).start();
		} catch (IOException e) {
				System.err.println("Pb lors de la création du serveur : " +  e);			
		}
	}
}
