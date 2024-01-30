package hearthstone.champion;

import hearthstone.champion.Champion;
import hearthstone.champion.ChampionAttaquant;
import hearthstone.champion.ChampionListener;
import hearthstone.champion.ChampionSniper;
import hearthstone.monstre.Monstre;

public class TestSniper {
    public static void main(String[] args) {
        // Création d'une instance de ChampionAttaquant
        ChampionAttaquant champion = new ChampionAttaquant() {
            @Override
            public void utiliserCapacite() {
                // Ne fait rien dans ce contexte, car ChampionAttaquant ne définit pas cette méthode.
            }

            @Override
            public void utiliserCapacite(Champion cible) {
                // Ne fait rien dans ce contexte, car ChampionAttaquant ne définit pas cette méthode.
            }

            @Override
            public void utiliserCapacite(Monstre cible) {
                // Ne fait rien dans ce contexte, car ChampionAttaquant ne définit pas cette méthode.
            }

            @Override
            public void mourir() {
                // Logique pour gérer la mort du champion
                System.out.println(getNom() + " est mort !");
            }
        };

        // Création d'une instance de ChampionSniper
        ChampionSniper sniper = new ChampionSniper() {
            @Override
            public void utiliserCapacite() {
                super.utiliserCapacite(); // Appel de la méthode de la classe parente
                // Logique supplémentaire spécifique au ChampionSniper
                System.out.println("Capacité spéciale du Sniper activée !");
            }

            @Override
            public void mourir() {
                // Logique pour gérer la mort du champion
                System.out.println(getNom() + " est mort !");
            }

            @Override
            public void utiliserCapacite(Champion cible) {

            }

            @Override
            public void utiliserCapacite(Monstre cible) {

            }
        };

        // Assurez-vous que le sniper a un écouteur pour gérer l'attaque
        sniper.setListener(new ChampionListener() {
            @Override
            public void mortChampion() {
                // Ne fait rien dans ce contexte
            }

            @Override
            public void attaquerAdversaire(int amount) {
                // Logique pour réduire les points de vie de l'adversaire
                champion.prendreDegats(amount);
            }

            @Override
            public void finDuTour() {
                // Ne fait rien dans ce contexte
            }
        });

        // Affichage des PV du champion avant l'attaque
        System.out.println("PV du champion avant l'attaque : " + champion.getPv());

        // Utilisation de la capacité spéciale du ChampionSniper
        sniper.utiliserCapacite();

        // Affichage des PV du champion après l'attaque
        System.out.println("PV du champion après l'attaque : " + champion.getPv());
    }
}

