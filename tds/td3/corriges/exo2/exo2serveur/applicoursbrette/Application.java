package applicoursbrette;

import java.util.*;

import cours.Cours;
import serveur.*;

class Application {
	private final static int PORT = 3000;

	public static void main(String[] args) throws Exception {
			List<Cours> lesCours = initCours();
			ServiceCours.setLesCours(lesCours);
			
			new Thread(new ServeurCours(PORT)).start();
			System.out.println("Serveur lance sur le port " + PORT);
	}

	private static List<Cours> initCours() {
		List<Cours> cours = new ArrayList<Cours>();
		cours.add(new CoursBrette(1, "AppServJava", 120));
		cours.add(new CoursBrette(2, "AppWebJava", 120));
		cours.add(new CoursBrette(3, "AppRefJava", 60));
		return cours;
	}
}
