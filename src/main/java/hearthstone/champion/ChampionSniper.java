package hearthstone.champion;

import hearthstone.monstre.Monstre;

public class ChampionSniper extends Champion {
    private int degats;

    public ChampionSniper(int id, String nom, int degats, String cheminVersLeDeck) {
            super(id, nom, cheminVersLeDeck);
            this.degats = degats;
    }

    @Override
    public void mourir() {

    }

    @Override
    public void utiliserCapacite() {

    }

    @Override
    public void utiliserCapacite(Monstre cible) {
      
    }

    @Override
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
        attaquetEtIgnorerProtecteur(this,cible);
        printAndLog(this.getNom() + " attaque avec " + this.degats + " de dégâts.","info");
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }


    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
