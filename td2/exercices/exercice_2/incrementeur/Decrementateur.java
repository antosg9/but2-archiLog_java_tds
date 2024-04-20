package incrementeur;

public class Decrementateur implements Runnable{

	public Decrementateur(Object verrouCpt)
	{
		this.verrouCpt=verrouCpt;
	}
	
	private static Object verrouCpt; //Création d'un objet à utiliser pour synchronized

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
