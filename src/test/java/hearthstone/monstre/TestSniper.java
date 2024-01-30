package hearthstone.monstre;
import hearthstone.champion.ChampionAttaquant;
import hearthstone.champion.ChampionSniper;
import junit.framework.TestCase;

public class TestSniper extends TestCase {

    //Verifie que la capacité spéciale du sniper passe outre la protection d'un monstre
    public static void main(String[] args) {

        //Chemin vers les decks
        String pathToDeck2 = System.getProperty("user.dir")+"\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstresJ2.txt";
        String pathToDeck1 = System.getProperty("user.dir")+"\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstres.txt";
        // Création des champions
        ChampionAttaquant championAttaquant = new ChampionAttaquant(1, "Mage",pathToDeck2, 2);
        ChampionSniper championSniper = new ChampionSniper(2, "Sniper", 3,pathToDeck1);
        MonstreFactory maFactoryTest = new MonstreFactory();

        MonstreProtecteur mProtec = maFactoryTest.buildProtecteur(3, 200, "Protecteur");


        assertEquals("Sniper",championSniper.getNom());
        assertEquals(30,championSniper.getPv());
        assertEquals("Mage",championAttaquant.getNom());

        mProtec.proteger(championAttaquant);
        assertEquals(true, championAttaquant.isProtected());


        // Affichage des PV du champion Sniper avant l'attaque
        System.out.println("PV du champion Sniper avant l'attaque : " + championSniper.getPv());
        assertEquals(30,championSniper.getPv());

        // Attaque du champion attaquant sur le champion sniper
        championAttaquant.utiliserCapacite(championSniper);
        assertEquals(28,championSniper.getPv());
        // Affichage des PV du champion sniper après l'attaque
        System.out.println("PV du champion sniper après l'attaque : " + championSniper.getPv());

        // Affichage des PV du champion attaquant avant l'attaque du champion sniper
        System.out.println("PV du champion attaquant avant l'attaque du champion sniper : " + championAttaquant.getPv());
        assertEquals(30,championAttaquant.getPv());
        // Utilisation de la capacité spéciale du champion sniper deux fois.
        championSniper.utiliserCapacite(championAttaquant);

        // Affichage des PV du champion attaquant après l'attaque du champion sniper
        System.out.println("PV du champion attaquant après l'attaque du champion sniper : " + championAttaquant.getPv());
        assertEquals(27,championAttaquant.getPv());
    }

    private static void poserMonstre(Monstre monstre) {
    }
}
