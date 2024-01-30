package hearthstone.monstre;
import hearthstone.champion.ChampionAttaquant;
import hearthstone.champion.ChampionSniper;

public class TestCapacite2fois {
    public static void main(String[] args) {

        // Chemins vers les decks
        String pathToDeck1 = System.getProperty("user.dir")+"\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstres.txt";
        String pathToDeck2 = System.getProperty("user.dir")+"\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstresJ2.txt";
        // Creation des champions
        ChampionAttaquant championAttaquant = new ChampionAttaquant(1, "Mage",pathToDeck2, 2);
        ChampionSniper championSniper = new ChampionSniper(2, "Sniper", 3,pathToDeck1);

        // Affichage des PV du champion attaquant avant l'attaque
        System.out.println("PV du champion attaquant avant l'attaque : " + championAttaquant.getPv());


        // Affichage des PV du champion attaquant après avoir posé le Monstre Protecteur
        System.out.println("PV du champion attaquant après avoir posé le Monstre Protecteur : " + championAttaquant.getPv());

        // Attaque du champion attaquant sur le champion sniper
        championAttaquant.utiliserCapacite(championSniper);

        // Affichage des PV du champion attaquant après l'attaque
        System.out.println("PV du champion sniper après l'attaque : " + championSniper.getPv());

        // Utilisation de la capacité spéciale du champion sniper
        championSniper.utiliserCapacite(championAttaquant);
        championSniper.utiliserCapacite(championAttaquant);

        // Affichage des PV du champion attaquant après l'attaque du champion sniper
        System.out.println("PV du champion attaquant après l'attaque du champion sniper : " + championAttaquant.getPv());
    }

    private static void poserMonstre(Monstre monstre) {
        // Votre logique pour poser le monstre ici...
    }
}
