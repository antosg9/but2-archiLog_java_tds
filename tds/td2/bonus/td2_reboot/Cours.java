package td2_reboot;

public class Cours {
	private static int placesMax;
	private static int nbInscrits;
	private String nomCours;
	
	public Cours(String nomCours, int placesMax)
	{
		this.nomCours=nomCours;
		Cours.placesMax=placesMax;
		Cours.nbInscrits=0;
	}
	
	public void inscription(String clientName, int nbDemande)
	{
		synchronized (this) {
			if(nbDemande>0 && nbDemande<= getPlaces())
			{
				Cours.nbInscrits = Cours.nbInscrits + nbDemande;
				System.out.println(clientName+" : "+nbDemande + " incriptions faites au cours de "+this.nomCours +"! Il reste "+getPlaces()+" places.");
			}
			
			else
				System.out.println(clientName+" : Opération impossible, le cours de "+this.nomCours +" est plein !");
		}
	}
	
	private int getPlaces() {
		return(Cours.placesMax-Cours.nbInscrits);
	}
}
