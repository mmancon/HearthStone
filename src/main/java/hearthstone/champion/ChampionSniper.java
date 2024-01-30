package hearthstone.champion;

import hearthstone.monstre.Monstre;

public class ChampionSniper extends Champion {
    private int degats;

    public ChampionSniper(int id, String nom, int degats, String cheminVersLeDeck) {
            super(id, nom, cheminVersLeDeck);
            this.degats = degats;
        printAndLog("Création d'un Champion de type Sniper du nom de "+this.getNom()+" et ayant "+this.getPv()+" PVs", "info");
    }

    @Override
    public void mourir() {

    }

    @Override
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true;
        printAndLog(this.getNom() + " attaque "+cible.getNom()+" et lui inflige " + this.degats + " de dégâts.","info");
        cible.attaquetEtIgnorerProtecteur(this, cible);
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }

    @Override
    public void utiliserCapacite(Monstre cible) {
      
    }

    @Override
    public void utiliserCapacite() {

    }


    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
