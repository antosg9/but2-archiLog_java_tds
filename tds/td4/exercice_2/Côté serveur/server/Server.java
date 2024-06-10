package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	private int numPort;
	private Cours cours;
	private Class<? extends Service> service;

	public Server(int numPort, Cours cours, Class<? extends Service> service)
	{
		this.numPort=numPort;
		this.cours=cours;
		this.service=service;
		this.start();
	}

	public void run()
	{
		try {

			ServerSocket serverSocket = new ServerSocket(this.numPort);

			while(true) //trouver une condition d'arrêt du serveur
			{
				Socket clientSocket = serverSocket.accept();
				System.out.println("New client connected : " + clientSocket.getInetAddress());
				Service s = this.service.newInstance();
				s.setArguments(clientSocket, cours);
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