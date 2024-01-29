package hearthstone.carte;

import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreFactory;

import java.util.logging.Logger;

public class Carte {
    Logger logger = Logger.getLogger("hearthstone.game");
    private final String nom;
    private final int pv;
    private final String type; // indique le type de carte : Protecteur / Classique / Soigneur ..
    private final int degats;
    private final int soins;
    private final int pourcentageBuff;

    private final MonstreFactory factoryCartes = new MonstreFactory(); // Les cartes utilisent la factory pour générer des monstres

    public Carte( String nom, int pv, String type, int degats, int soins, int pourcentageBuff) {
        this.nom = nom;
        this.pv = pv;
        this.type = type;
        this.degats = degats;
        this.soins = soins;
        this.pourcentageBuff = pourcentageBuff;
    }

    public Monstre invoquerMonstre(int id){
        if (type.equals("classique"))
            return factoryCartes.buildClassique(id, pv, nom, degats);
        if (type.equals("protecteur"))
            return factoryCartes.buildProtecteur(id, pv, nom);
        if (type.equals("mascotte"))
            return factoryCartes.buildMascotte(id, pv, nom, pourcentageBuff);
        if (type.equals("soigneur"))
            return factoryCartes.buildSoigneur(id, pv, nom, soins);
        else {
            logger.warning("Le type de carte "+type+" n'existe pas");
            return null;
        }
    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public String getType() {
        return type;
    }

    public int getDegats() {
        return degats;
    }

    public int getSoins() {
        return soins;
    }

    public int getPourcentageBuff() {
        return pourcentageBuff;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "nom='" + nom + '\'' +
                ", pv=" + pv +
                ", type='" + type + '\'' +
                ", degats=" + degats +
                ", soins=" + soins +
                ", pourcentageBuff=" + pourcentageBuff +
                '}';
    }

}
