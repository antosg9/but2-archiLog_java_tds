package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	private int numPort;
	private Cours cours;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private Class<? extends Service> service;

	public Server(int numPort, Cours cours, Class<? extends Service> service) throws IOException
	{
		this.numPort=numPort;
		this.cours=cours;
		this.service=service;
		this.serverSocket = new ServerSocket(this.numPort);
		this.start();

	}

	public void run()
	{
		while(true)
		{
			try {
				this.clientSocket = this.serverSocket.accept();
				System.out.println("New client connected : " + clientSocket.getInetAddress());
				
				Service s = this.service.newInstance();
				s.setSocket(this.clientSocket);
				s.setCours(this.cours);
				s.lancerService();
				
				
			} catch (IOException | InstantiationException | IllegalAccessException e) {e.printStackTrace();}
		}

		//serverSocket.close();
		//System.out.println("Server closed");
	}
}