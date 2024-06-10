package td2_reboot;

public class Inscription extends Thread{

	private int nbDemande;
	private String clientName;
	private Cours cours;
	
	public Inscription(int nbDemande, String clientName, Cours cours)
	{
		this.nbDemande=nbDemande;
		this.clientName=clientName;
		this.cours=cours;
		this.start();
	}
	
	public void run()
	{
		cours.inscription(this.clientName, this.nbDemande);
	}
}
