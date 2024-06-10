package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class Service_InscriptionCours implements Runnable, Service{
	
	private Socket socketClient;
	private Cours cours;
	private String clientName, message;
	private int nbDemande;
	
	Service_InscriptionCours()
	{}
	
	public void run()
	{
		try {
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(this.socketClient.getInputStream())); //Flux récepteur
			PrintWriter socketOut = new PrintWriter(new OutputStreamWriter(this.socketClient.getOutputStream()), true); //Flux envoyeur
			
			nbDemande=Integer.parseInt(socketIn.readLine());
			this.message= cours.inscription(this.clientName, this.nbDemande);
			
			socketOut.println(this.message); //Envoi de la donnée
		
		    //Fermeture des flux entrants, sortants
			socketIn.close();		
			socketOut.close();
			
			//Fermeture du socket client
			this.socketClient.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setSocket(Socket socket) {
		this.socketClient=socket;
		this.clientName=this.socketClient.getInetAddress().toString();
		
	}

	@Override
	public void setCours(Cours cours) {
		this.cours=cours;		
	}

	@Override
	public void lancerService() {
		new Thread(this).start();
		
	}	
}