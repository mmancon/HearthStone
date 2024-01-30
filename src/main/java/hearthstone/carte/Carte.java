package hearthstone.carte;

import com.fasterxml.jackson.annotation.JsonCreator;
import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreFactory;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carte {
    Logger logger = Logger.getLogger("hearthstone.game");
    @JsonProperty("nom")
    private final String nom;
    @JsonProperty("pv")
    private final int pv;
    @JsonProperty("type")
    private final String type; // indique le type de carte : Protecteur / Classique / Soigneur ..
    @JsonProperty("degats")
    private final int degats;
    @JsonProperty("soins")
    private final int soins;
    @JsonProperty("pourcentageBuff")
    private final int pourcentageBuff;

    private final MonstreFactory factoryCartes = new MonstreFactory(); // Les cartes utilisent la factory pour générer des monstres

    @JsonCreator
    public Carte(@JsonProperty("nom") String nom,
                 @JsonProperty("pv") int pv,
                 @JsonProperty("type") String type,
                 @JsonProperty("degats") int degats,
                 @JsonProperty("soins") int soins,
                 @JsonProperty("pourcentageBuff") int pourcentageBuff) {
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

    // Getters et setters
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
