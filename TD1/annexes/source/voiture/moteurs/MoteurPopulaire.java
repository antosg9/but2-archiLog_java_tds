package voiture.moteurs;

import voiture.Voiture;

public class MoteurPopulaire extends MoteurStandard {
  private static final int VITESSE_MAX = 180;

  @Override
  public int getVitesseMaximale(Voiture voiture) {
    return VITESSE_MAX;
  }

  private static final int SEUIL = 100;
  private static final int PAS_ACCEL = 10;

  @Override
  public void accélérer(Voiture voiture) {
    if (voiture.getVitesse() > SEUIL) {
      int v = voiture.getVitesse() + PAS_ACCEL;
      voiture.setVitesse(v < voiture.getVitesseMaximale() ? v : voiture
          .getVitesseMaximale());
    } else
      super.accélérer(voiture);
  }
}
