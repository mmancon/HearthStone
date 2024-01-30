package hearthstone.main;
import hearthstone.champion.ChampionInvocateur;
import hearthstone.champion.ChampionSniper;
import hearthstone.monstre.*;

import java.io.IOException;
import java.util.logging.FileHandler;
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

        String pathToDeck1 = System.getProperty("user.dir")+"\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstres.txt";
        String pathToDeck2 = System.getProperty("user.dir")+"\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstresJ2.txt";

        ChampionInvocateur champ1 = new ChampionInvocateur(0, "Michel", pathToDeck1,new MonstreFactory());
        System.out.println(champ1.getMain().get(2));
        champ1.jouerCarte(champ1.getMain().get(2), champ1.getTerrain().toArray().length);
        System.out.println(champ1.getTerrain().get(0).getNom());
        System.out.println(champ1.getMain().toArray().length);

        ChampionSniper champ2 = new ChampionSniper(1, "Léon", 10, pathToDeck2);
        System.out.println(champ2.getMain().toArray().length);
    }
}
