package hearthstone.champion;

import hearthstone.monstre.Monstre;
public class ChampionAttaquant extends Champion {
    private int degats;

    public ChampionAttaquant(int id, String nom, String cheminVersLeDeck,int degats) {
        super(id, nom, cheminVersLeDeck);
        this.degats = degats;
        printAndLog("Création d'un Champion de type Attaquant du nom de "+this.getNom()+" et ayant "+this.getPv()+" PVs", "info");
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
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour infliger "+degats+ " à "+cible.getNom(), "info");
            cible.prendreDegats(degats);
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
