package hearthstone.champion;

import hearthstone.carte.Carte;
import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreMascotte;
import hearthstone.monstre.MonstreProtecteur;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public abstract class Champion {
    Logger logger = Logger.getLogger("hearthstone.game");
    private int pv = 300;
    private final int pvMax = 300;
    private String nom;
    public boolean capaciteUtilisee; // Cette variable passe à vrai lorsqu'un champion utilise sa capacité lors d'un tour, il ne peut donc l'utiliser qu'une fois par tour
    private int id;
    private String capacite;
    private ArrayList<Carte> main;
    private ArrayList<Monstre> equipe;
    private boolean isProtected = false; // Lorsqu'un MonstreProtecteur protège cette entité : cette variable passe à vraie
    private MonstreProtecteur protecteur;


    public Champion(int id, String nom, String cheminVersLeDeck) {
        this.id = id;
        this.nom = nom;
        main = genererDeck(cheminVersLeDeck);
        equipe = new ArrayList<>();
    }

    public void prendreDegats(int degats) {
        if (!this.isProtected || degats < 0) { // Si ce champion n'est pas protégé OU s'il se fait soigner
            this.pv -= degats;
            printAndLog(getNom()+" a désormais "+getPv()+"/"+getPvMax()+" PVs.", "info");
            if (this.pv <= 0) {
                this.pv = 0;
                printAndLog(getNom() + " est mort"+" avec "+getPv()+" PV !", "info");            }
        } else {
            protecteur.prendreDegats(degats);
        }
    }

    public void printAndLog(String message, String level) {
        // System.out.println(message); On laisse cette ligne commentée pour le debug
        if (level.equals("info"))
            logger.info(message);
        else if (level.equals("warning"))
            logger.warning(message);
    }

    public void MortMonstre(Monstre m) {
        getEquipe().remove(m);
    }

    public void jouerCarte(Carte carteUtilisee, int id) {
        main.remove(carteUtilisee);
        equipe.add(carteUtilisee.invoquerMonstre(id));
    }

    protected ArrayList<Carte> genererDeck(String cheminVersLeJson) {
        ArrayList<Carte> deck = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(cheminVersLeJson);

            // Désérialise le fichier JSON en une liste d'objets Carte
            Carte[] cartes = objectMapper.readValue(file, Carte[].class);

            deck.addAll(Arrays.asList(cartes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printAndLog("Récupération du deck de "+deck.toArray().length+" cartes pour le joueur "+getNom(), "info");
        return deck;
    }

    //Permet à la capacité du sniper de passer outre le protecteur
    protected void attaquetEtIgnorerProtecteur(ChampionSniper sniper, Champion cible){
        cible.setPv(cible.getPv()-sniper.getDegats());
        printAndLog(getNom()+" a désormais "+getPv()+"/"+getPvMax()+" PVs.", "info");
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getId() {
        return id;
    }

    public boolean capaciteUtilisee() {
        return capaciteUtilisee;
    }

    public ArrayList<Monstre> getEquipe() {
        return equipe;
    }

    public ArrayList<Carte> getMain(){
        return main;
    }

    protected void setCapaciteUtilisee(boolean capaciteUtilisee) {
        this.capaciteUtilisee = capaciteUtilisee;
    }
    public abstract void utiliserCapacite(Champion cible);
    // Methodes qui permettent aux champions d'utiliser leurs capacités sur un champion adverse ou un monstre
    public abstract void utiliserCapacite(Monstre cible);

    protected void setId(int id) {
        this.id = id;
    }

    protected void setPv(int pv) {
        this.pv = pv;
    }

    protected void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public void setProtecteur(MonstreProtecteur monstre){
        this.protecteur = monstre;
    }
    public abstract void utiliserCapacite();

    public int getPvMax() {
        return pvMax;
    }
}