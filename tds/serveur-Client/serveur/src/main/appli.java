package main;

import java.io.IOException;

import Service.Service_Lambda;
import server.Server;

public class appli {

	public static void main(String[] args) throws IOException {
		
		int numPort = 1234;
		
		new Server(numPort, Service_Lambda.class);
	}
	
}