package td2_reboot;

public class appli {

	public static void main(String[] args) throws InterruptedException {
		Cours maths = new Cours("Maths",10);
		
		new Inscription(2,"Max",maths);
		new Inscription(3,"Stan",maths);
		new Inscription(6,"Laurie",maths);
	}
}
