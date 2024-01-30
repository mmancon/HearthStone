package hearthstone.champion;

import hearthstone.monstre.Monstre;
public class ChampionAttaquant extends Champion {
    private int degats;

    public ChampionAttaquant(int id, String nom, String cheminVersLeDeck,int degats) {
        super(id, nom, cheminVersLeDeck);
        this.degats = degats;
    }


    @Override
    public void utiliserCapacite(Monstre cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour infliger "+degats+ " à "+cible.getNom(), "info");
            cible.prendreDegats(degats);
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }

    @Override
    public void utiliserCapacite() {

    }

    @Override
    public void mourir() {

    }

    @Override
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            cible.prendreDegats(degats);
            printAndLog(getNom() + " utilise sa capacité pour infliger "+degats+ " à "+cible.getNom(), "info");
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
