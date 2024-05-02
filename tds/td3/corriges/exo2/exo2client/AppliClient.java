package exo2client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*ce client reçoit les deux questions du service
 
*/

public class AppliClient {
		private static int PORT = 3000;
		private static String HOST = "localhost"; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));			
		
		Socket socket = null;		
		try {
			socket = new Socket(HOST, PORT);
			BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);
			// Informe l'utilisateur de la connection
			System.out.println("Connecté au serveur " + socket.getInetAddress() + ":"+ socket.getPort());

			String line;
			line = sin.readLine(); // 1ère question
			System.out.println(line);
			// prompt d'invite à la saisie
			System.out.print("->");
			line = clavier.readLine();
			sout.println(line);
			line = sin.readLine(); // 2ème question
			System.out.println(line);
			// prompt d'invite à la saisie
			System.out.print("->");
			line = clavier.readLine();
			sout.println(line);
			
			System.out.println(sin.readLine()); // réponse finale
	
			socket.close();
		}
		catch (IOException e) { System.err.println("Fin du service"); }
		// Refermer dans tous les cas la socket
		try { if (socket != null) socket.close(); } 
		catch (IOException e2) { ; }		
	}

	private static boolean isNumeric(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
