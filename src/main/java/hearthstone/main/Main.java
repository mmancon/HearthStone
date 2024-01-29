package hearthstone.main;
import hearthstone.monstre.*;

import java.io.IOException;
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


        MonstreFactory maFactoryTest = new MonstreFactory();
        MonstreSoigneur mSoin = maFactoryTest.buildSoigneur(0, 100, "Le soigneur trop sympa", 12);
        MonstreClassique m1 = maFactoryTest.buildClassique(1, 35, "Le monstre qui se fait boloss", 2);
        MonstreClassique m2 = maFactoryTest.buildClassique(2, 3, "Le méchant", 100);
        MonstreMascotte mMascotte = maFactoryTest.buildMascotte(5, 50, "Le bras droit du méchant", 100);


        MonstreProtecteur mProtec = maFactoryTest.buildProtecteur(3, 200, "Protecteur");
        mProtec.proteger(m1);

        mMascotte.buffer(m2);

        m2.attaquer(m1);
        mSoin.soigner(m1);

    }
}
