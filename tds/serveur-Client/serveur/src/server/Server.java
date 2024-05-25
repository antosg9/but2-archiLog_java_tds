package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Service.Service;

public class Server extends Thread {

	private int numPort;
	private Class<? extends Service> service;

	public Server(int numPort, Class<? extends Service> service)
	{
		this.numPort=numPort;
		this.service=service;
		this.start();
	}

	public void run()
	{
		try {

			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(this.numPort);

			while(true) //trouver une condition d'arrêt du serveur
			{
				Socket clientSocket = serverSocket.accept();
				System.out.println("New client connected : " + clientSocket.getInetAddress());
				@SuppressWarnings("deprecation")
				Service s = this.service.newInstance();
				s.setSocket(clientSocket);
				s.launchService();
			}

		} catch (IOException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//Lorsque la condition d'arrêt sera trouvée
		//serverSocket.close();
		//System.out.println("Server closed");
	}
}