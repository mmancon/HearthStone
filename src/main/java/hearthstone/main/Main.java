package hearthstone.main;
import hearthstone.carte.Carte;
import hearthstone.carte.Deck;
import hearthstone.monstre.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
    public static void main( String[] args )
    {
        // Création du Logger
        Logger logger = Logger.getLogger("hearthstone.game");
        FileHandler fh = null;
        try {
            fh = new FileHandler("./HearthStone_Partie.log");
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        logger.info("Execution du Main");

        ArrayList<Carte> deck1 = new ArrayList<>();
        deck1.add(new Carte("Dragon", 100, "classique", 50, 0, 0));
        deck1.add(new Carte("Spartiate", 70, "classique", 65, 0, 0));
        deck1.add(new Carte("Valkyrie", 30, "soigneur", 0, 30, 0));
        deck1.add(new Carte("Cerbère", 150, "protecteur", 0, 0, 0));
        deck1.add(new Carte("Prêtre", 45, "mascotte", 0, 0, 50));
        deck1.add(new Carte("Minotaure", 130, "protecteur", 0, 0, 0));
        deck1.add(new Carte("Magicien", 30, "mascotte", 0, 0, 60));
        ArrayList<Carte> deck2 = new ArrayList<>();
        deck2.add(new Carte("Méduse", 60, "soigneur", 0, 15, 0));
        deck2.add(new Carte("Centaure", 80, "mascotte", 0, 0, 35));
        deck2.add(new Carte("Géant", 85, "classique", 55, 0, 0));
        deck2.add(new Carte("Pégase", 40, "soigneur", 0, 20, 0));
        deck2.add(new Carte("Griffon", 50, "classique", 70, 0, 0));
        deck2.add(new Carte("Sphinx", 110, "protecteur", 0, 0, 0));
        deck2.add(new Carte("Troll", 95, "classique", 70, 0, 0));

        Monstre m1 = deck1.get(0).invoquerMonstre(0);
        m1.getNom();


    }
}
