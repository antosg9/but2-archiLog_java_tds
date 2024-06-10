package main;

import java.io.IOException;

import server.Cours;
import server.Server;
import server.Service_InscriptionCours;

public class appli {

	public static void main(String[] args) throws IOException {
		
		Cours cours = new Cours("Maths",10); //1 cours seulement pour démontrer le fonctionnement
		int numPort = 1234;
		
		new Server(numPort, cours, Service_InscriptionCours.class);
	}
	
}