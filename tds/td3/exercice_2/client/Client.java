package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String adress = "localhost";
		int numPort = 1234;
		
		Socket socket = new Socket(adress,numPort);
		
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nombre de places à réserver : ");
		
		//Envoyer de la donnée
		PrintWriter socketOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        socketOut.println(scanner.nextLine());
        
        //Lire la réponse du serveur
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Réponse du serveur : " + socketIn.readLine());
        
        //Fermeture des flux
        socketOut.close();
        socketIn.close();
        
        socket.close(); //Fermeture de la connexion (socket)
	}
}
