package hearthstone.champion;

import hearthstone.monstre.Monstre;
public abstract class ChampionAttaquant extends Champion {
    private int degats;

    public ChampionAttaquant(int id, int pv, String nom, int degats) {
        super(id, pv, nom);
        this.degats = degats;
    }

    @Override
    public void utiliserCapacite(Monstre cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            System.out.println(getNom() + " utilise sa capacité pour attaquer !");
            cible.prendreDegats(200);
        } else {
            System.out.println("Impossible, la capacité a déjà été utilisée ce tour-ci.");
        }
    }
    @Override
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            System.out.println(getNom() + " utilise sa capacité pour attaquer !");
            cible.prendreDegats(200);
        } else {
            System.out.println("Impossible, la capacité a déjà été utilisée ce tour-ci.");
        }
    }


    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
