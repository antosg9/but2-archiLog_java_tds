package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class clientHandler extends Thread{
	
	private Socket clientSocket;
	private Cours cours;
	
	private int nbDemande;
	private String clientName, message;
	
	clientHandler(Socket clientSocket, Cours cours) throws IOException
	{
		this.clientSocket=clientSocket;
		this.cours=cours;
	
		this.clientName=clientSocket.getInetAddress().toString();
		
		this.start();
	}
	
	public void run()
	{	
		try {
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream())); //Flux récepteur
			PrintWriter socketOut = new PrintWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()), true); //Flux envoyeur
			
			nbDemande=Integer.parseInt(socketIn.readLine());
			clientName=clientSocket.getInetAddress().toString();
			this.message= cours.inscription(this.clientName, this.nbDemande);
			
			socketOut.println(this.message); //Envoi de la donnée
		
		    //Fermeture des flux entrants, sortants
			socketIn.close();		
			socketOut.close();
			
			//Fermeture du socket client
			clientSocket.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}