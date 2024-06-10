package server;

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
	
	public String inscription(String clientName, int nbDemande)
	{
		synchronized (this) {
			if(nbDemande>0 && nbDemande<= getPlaces())
			{
				Cours.nbInscrits = Cours.nbInscrits + nbDemande;
				return(clientName+" : "+nbDemande + " incriptions faites au cours de "+this.nomCours +"! Il reste "+getPlaces()+" places.");
			}
			
				return(clientName+" : Opération impossible, le cours de "+this.nomCours +" est plein !");
		}
	}
	
	private int getPlaces() {
		return(Cours.placesMax-Cours.nbInscrits);
	}
}
