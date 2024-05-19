package main;

import java.io.IOException;

import server.Cours;
import server.Server;
import server.Service_InscriptionCours;

public class appli {

	public static void main(String[] args) throws IOException {
		Cours maths = new Cours("Maths",10); //1 cours seulement pour démontrer le fonctionnement
		new Server(1234, maths, Service_InscriptionCours.class);
	}

}
