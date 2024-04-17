package voiture.moteurs;

import voiture.IMoteur;
import voiture.Voiture;

public class MoteurStandard implements IMoteur {

  private static final int VITESSE_MAX = 240;

  @Override
  public int getVitesseMaximale(Voiture voiture) {
    return VITESSE_MAX;
  }

  private static final int PAS_ACCEL = 25;

  @Override
  public void accélérer(Voiture voiture) {
    int v = voiture.getVitesse() + PAS_ACCEL;
    voiture.setVitesse(v < voiture.getVitesseMaximale() ? v : voiture
        .getVitesseMaximale());
  }

}
