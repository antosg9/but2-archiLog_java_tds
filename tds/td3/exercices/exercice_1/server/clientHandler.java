package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class clientHandler extends Thread{
	
	Socket clientSocket;
	
	clientHandler(Socket clientSocket) throws IOException
	{
		this.clientSocket=clientSocket;
		this.start();
	}
	
	public void run()
	{	
		try {
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream())); //Flux récepteur
			
			StringBuffer response = new StringBuffer(socketIn.readLine()).reverse(); //Collecte + inversion de la réponse 
			
			PrintWriter socketOut = new PrintWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()), true); //Flux envoyeur
			socketOut.println(response.toString()); //Envoi de la donnée
		
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