package server;

import java.net.Socket;

public interface Service {
	
	public void setSocket(Socket socket);
	
	public void setArguments(Socket socket, Cours cours);
	
	public void launchService();
}