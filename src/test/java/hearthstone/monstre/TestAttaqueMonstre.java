package hearthstone.monstre;
import junit.framework.TestCase;

public class TestAttaqueMonstre extends TestCase {
    /**
     * TU du sujet : Vérifie qu'un monstre tue un autre monstre
     * &#064;Test
     */
    public void testMonstreFactory() {
        MonstreFactory maFactoryTest = new MonstreFactory();

        MonstreClassique m1 = maFactoryTest.buildClassique(1, 35, "Frappeur", 2000);
        MonstreClassique m2 = maFactoryTest.buildClassique(2, 3, "Frappé", 25);

        assertEquals(3, m2.getPv());
        assertEquals(2000, m1.getDegats());
        m1.attaquer(m2);
        assertEquals(0, m2.getPv());

    }
}
