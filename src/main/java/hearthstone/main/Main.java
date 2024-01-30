package hearthstone.main;

import hearthstone.champion.Champion;
import hearthstone.champion.ChampionAttaquant;
import hearthstone.champion.ChampionListener;
import hearthstone.champion.ChampionSniper;
import hearthstone.monstre.Monstre;

public class Main {
    public static void main(String[] args) {
        // Création d'une instance de ChampionAttaquant
        ChampionAttaquant champion = new ChampionAttaquant() {
            @Override
            public void utiliserCapacite() {
                // Ne fait rien dans ce contexte, car cette méthode ne sera pas appelée.
            }

            @Override
            public void utiliserCapacite(Champion cible) {
                // Infliger 1 point de dégât au champion adverse
                System.out.println(getNom() + " utilise sa capacité pour infliger 1 point de dégât au champion adverse : " + cible.getNom());
                cible.prendreDegats(1);
            }

            @Override
            public void utiliserCapacite(Monstre cible) {
                // Infliger 1 point de dégât au monstre adverse
                System.out.println(getNom() + " utilise sa capacité pour infliger 1 point de dégât au monstre adverse.");
                cible.prendreDegats(1);
            }

            @Override
            public void mourir() {
                // Logique pour gérer la mort du champion
                System.out.println(getNom() + " est mort !");
            }
        };

        // Création d'une instance de ChampionSniper comme champion adverse
        ChampionSniper championAdverse = new ChampionSniper() {
            @Override
            public void utiliserCapacite() {
                // Ne fait rien dans ce contexte
            }

            @Override
            public void mourir() {
                // Logique pour gérer la mort du champion adverse
                System.out.println(getNom() + " est mort !");
            }

            @Override
            public void utiliserCapacite(Champion cible) {

            }

            @Override
            public void utiliserCapacite(Monstre cible) {

            }
        };

        // Assurez-vous que le champion adverse a un écouteur pour gérer l'attaque
        championAdverse.setListener(new ChampionListener() {
            @Override
            public void mortChampion() {
                // Ne fait rien dans ce contexte
            }

            @Override
            public void attaquerAdversaire(int amount) {
                // Logique pour réduire les points de vie du champion attaquant
                champion.prendreDegats(amount);
            }

            @Override
            public void finDuTour() {
                // Ne fait rien dans ce contexte
            }
        });

        // Affichage des PV du champion adverse avant l'attaque
        System.out.println("PV du champion adverse avant l'attaque : " + championAdverse.getPv());

        // Utilisation de la capacité spéciale du ChampionAttaquant contre le champion adverse
        champion.utiliserCapacite(championAdverse);

        // Affichage des PV du champion adverse après l'attaque
        System.out.println("PV du champion adverse après l'attaque : " + championAdverse.getPv());
    }
}
