package server;

import java.net.Socket;

public interface Service {
	
	public void setSocket(Socket socket);
	public void setCours(Cours cours);
	public void lancerService();
}
