package hearthstone.monstre;
import junit.framework.TestCase;

public class monstreFactoryTest extends TestCase {
    /**
     * Vérife que la factory fonctionne
     * &#064;Test
     */
    public void testMonstreFactory() {
        MonstreFactory maFactoryTest = new MonstreFactory();

        MonstreSoigneur mSoin = maFactoryTest.buildSoigneur(0, 100, "Le soigneur trop sympa", 12);
        MonstreClassique m1 = maFactoryTest.buildClassique(1, 35, "Le monstre qui se fait boloss", 2);
        MonstreClassique m2 = maFactoryTest.buildClassique(2, 3, "Le méchant", 25);
        MonstreMascotte mMascotte = maFactoryTest.buildMascotte(5, 50, "Le bras droit du méchant", 100);

        MonstreProtecteur mProtec = maFactoryTest.buildProtecteur(3, 200, "Protecteur");

        // Vérifiez les caractéristiques initiales des monstres
        assertEquals("Protecteur", mProtec.getNom());
        assertEquals(200, mProtec.getPv());

        // Vérifiez la protection
        mProtec.proteger(m1);
        assertEquals(mProtec, m1.getProtecteur());
        assertEquals(m1, mProtec.getMonstreProtege());

        // Vérifiez le buff et l'attaque
        assertEquals(25, m2.getDegats());
        mMascotte.buffer(m2);
        assertEquals(100, mMascotte.getPourcentageBuff());
        assertEquals(25, m2.getDegats());

        // Vérifiez l'attaque et les dégâts subis
        assertEquals(35, m1.getPv());
        m2.attaquer(m1);
        assertEquals(35, m1.getPv());
        assertEquals(150, mProtec.getPv());

        // Vérifiez le soin
        assertEquals(12, mSoin.getQuantiteSoin());
        mSoin.soigner(m1);
        assertEquals(35, m1.getPv());
    }
}
