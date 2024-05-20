package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class Service_InscriptionCours implements Runnable, Service{

	private Socket clientSocket;
	private Cours cours;
	private String clientName;

	Service_InscriptionCours(){}

	public void run()
	{	
		try {

			BufferedReader socketIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream())); //Flux récepteur
			PrintWriter socketOut = new PrintWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()), true); //Flux envoyeur
			
			socketOut.println("Connexion établie !");

			while(true) 
			{
				socketOut.println("Combien de places souhaitez vous réserver ?");
				String request = socketIn.readLine();
				
				if(request.equalsIgnoreCase("exit"))
				{
					//Fermeture des flux
					socketOut.println("Arrêt du service");
					socketIn.close();		
					socketOut.close();
					this.clientSocket.close();
					return;
				}

				int numberAsked=Integer.parseInt(request);
				request= cours.inscription(this.clientName, numberAsked);

				socketOut.println(request); //Envoi de la donnée
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setSocket(Socket socket) {
		this.clientSocket=socket;
		this.clientName=this.clientSocket.getInetAddress().toString();
	}

	@Override
	public void setArguments(Socket socket, Cours cours) {
		this.setSocket(socket);
		this.cours=cours;
	}

	@Override
	public void launchService() {
		new Thread(this).start();
	}	
}