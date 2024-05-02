package cours;
/**
 * @author JFBrette
 *
 */
public class AppliADAC {

	public static void main(String[] args) {
		Cours cours = new Cours (1,"AppRefJava",30);
		
		new Thread(new Inscription(cours,15)).start();
		new Thread(new Inscription(cours,10)).start();
		new Thread(new Inscription(cours,12)).start();
		
	}

	
}
