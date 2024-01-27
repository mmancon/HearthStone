package hearthstone.main;

import hearthstone.monstre.*;

public class Main
{
    public static void main( String[] args )
    {
        MonstreFactory maFactoryTest = new MonstreFactory();
        MonstreSoigneur mSoin = maFactoryTest.buildSoigneur(0, 100, "Le soigneur trop sympa", 12);
        MonstreClassique m1 = maFactoryTest.buildClassique(1, 35, "Le monstre qui se fait boloss", 2);
        MonstreClassique m2 = maFactoryTest.buildClassique(2, 3, "Le méchant", 25);
        MonstreMascotte mMascotte = maFactoryTest.buildMascotte(5, 50, "Le bras droit du méchant", 100);


        MonstreProtecteur mProtec = maFactoryTest.buildProtecteur(3, 200, "Protecteur");
        System.out.println(mProtec.getNom()+" a "+mProtec.getPv()+" Pvs");
        System.out.println(mProtec.getNom()+" protège "+m1.getNom());
        mProtec.proteger(m1);

        System.out.println("\n"+m2.getNom()+" inflige en temps normal "+m2.getDegats());
        System.out.println(mMascotte.getNom()+" buff "+m2.getNom()+" à "+mMascotte.getPourcentageBuff()+"% ! ");
        mMascotte.buffer(m2);

        System.out.println("\n"+m1.getNom()+" a : "+m1.getPv()+" PVs");
        System.out.println(m2.getNom()+" attaque "+m1.getNom()+" et lui inflige "+m2.getDegats());
        m2.attaquer(m1);
        System.out.println(m1.getNom()+" a : "+m1.getPv()+" PVs");
        System.out.println(mProtec.getNom()+" a : "+mProtec.getPv()+" PVs");
        System.out.println(mSoin.getNom()+" soigne "+mSoin.getQuantiteSoin()+" pv à "+m1.getNom());
        mSoin.soigner(m1);
        System.out.println(m1.getNom()+" a : "+m1.getPv()+" PVs");
    }
}
