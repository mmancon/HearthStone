package hearthstone.main;
import hearthstone.champion.*;
import hearthstone.monstre.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import java.util.Random;


public class Main {
    public static void main(String[] args) throws Exception {
        // Création du Logger
        Logger logger = Logger.getLogger("hearthstone.game");
        FileHandler fh = null;
        try {
            fh = new FileHandler("./HearthStone_Partie.log");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        logger.info("Execution du Main");
        logger.info("Mathieu Mançon et Redouane Hamdoud");

        // Chemin vers les 2 decks des joueurs
        String pathToDeck1 = System.getProperty("user.dir") + "\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstres.txt";
        String pathToDeck2 = System.getProperty("user.dir") + "\\src\\main\\java\\hearthstone\\carte\\listeJsonMonstresJ2.txt";

        // Création des 2 champions
        ChampionSoigneur champ1 = new ChampionSoigneur(0, "Michel", pathToDeck1, 10);
        ChampionSniper champ2 = new ChampionSniper(1, "Léon", 3, pathToDeck2);

        ArrayList<Champion> listeJoueurs = new ArrayList<>();
        listeJoueurs.add(champ1);
        listeJoueurs.add(champ2);

        Random random = new Random();
        int nextPlayer = 0;
        int nextEnemy = 1;

        // Boucle de Jeu
        while (champ1.getPv() > 0 && champ2.getPv() > 0) {
            Champion currentPlayer = listeJoueurs.get(nextPlayer);
            Champion enemyChamp = listeJoueurs.get(nextEnemy);
            logger.info("C'est au tour de " + currentPlayer.getNom());

            // Partie 1 - Choix d'invocation d'un Monstre
            if (!currentPlayer.getMain().isEmpty()) { // S'il reste des cartes dans la main du joueur
                // Une chance sur deux pour que le champion utilise une carte (au premier tour le champion posera forcément une carte)
                if (random.nextInt(2) == 1 || currentPlayer.getEquipe().isEmpty()) {
                    logger.info(currentPlayer.getNom() + " décide de créer un monstre");
                    // On choisit un monstre au hasard et on l'invoque
                    currentPlayer.jouerCarte(choisirAleatoire(currentPlayer.getMain()), currentPlayer.getEquipe().size());
                } else logger.info(currentPlayer.getNom() + " décide de ne pas créer un monstre");
            }

            // Partie 2 - Choix d'utilisation de la capacité spéciale
            if (random.nextInt(2) == 1) {
                logger.info(currentPlayer.getNom() + " décide d'utiliser sa capacité spéciale");
                if (!currentPlayer.getClass().equals(ChampionSoigneur.class)) { // Si le champion n'est pas un soigneur, on vise l'adversaire
                    // On essaie d'abord d'utiliser la capacité d'abord sur le champion
                    currentPlayer.utiliserCapacite(enemyChamp);
                    // Puis on essaie de l'utiliser sur un des monstres de l'adversaire
                    if (!enemyChamp.getEquipe().isEmpty()) { // Si l'adversaire a des monstres dans son équipe
                        Monstre cible = choisirAleatoire(enemyChamp.getEquipe());
                        currentPlayer.utiliserCapacite(cible);
                        if (cible.getPv() < 0){
                            enemyChamp.getEquipe().remove(cible);
                        }
                    }
                    // Sinon on l'utilise sans cible
                    currentPlayer.utiliserCapacite();

                } else { // Si le champion est un soigneur, on vise les alliés
                    if (!currentPlayer.getEquipe().isEmpty()) // Si son équipe n'est pas vide
                        currentPlayer.utiliserCapacite(choisirAleatoire(currentPlayer.getEquipe())); // On soigne un des monstres
                    else
                        logger.info("Cependant son équipe est vide");
                }
            } else
                logger.info(currentPlayer.getNom() + " a décidé de ne pas utiliser sa capacité spéciale");

            // Partie 3 : Chaque Monstre dans l'équipe du joueur choisis d'utiliser sa capacité ou non sur une cible
            if (!currentPlayer.getEquipe().isEmpty()) { // Si l'équipe du joueur n'est pas vide
                for (Monstre monstre : currentPlayer.getEquipe()) {
                    logger.info("Au tour de " + monstre.getNom() + " :");
                    if (monstre.getClass().equals(MonstreMascotte.class)) {
                        if (((MonstreMascotte) monstre).getMonstreBuffed() == null && !verifierClasse(currentPlayer.getEquipe(), MonstreMascotte.class)) {
                            // On choisit un monstre qui n'est pas une Mascotte au hasard (dans notre équipe) à buffer
                            ((MonstreMascotte) monstre).buffer(choisirAleatoireAvecExclusionDeClasse(currentPlayer.getEquipe(), MonstreMascotte.class));
                        }
                    } else if (monstre.getClass().equals(MonstreClassique.class)) {
                        if (enemyChamp.getEquipe().isEmpty()) { // Si l'équipe de l'adversaire est vide
                            ((MonstreClassique) monstre).attaquer(enemyChamp); // On attaque le champion
                        } else { // Sinon, on choisit un monstre au hasard dans l'équipe adverse à attaquer
                            Monstre cible = choisirAleatoire(enemyChamp.getEquipe());
                            ((MonstreClassique) monstre).attaquer(cible);
                            if (cible.getPv() < 0) { // Si le coup tue la cible, on la retire de l'équipe
                                enemyChamp.getEquipe().remove(cible);
                            }
                        }
                    } else if (monstre.getClass().equals(MonstreSoigneur.class)) {
                        if (currentPlayer.getEquipe().size() == 1) { // Si l'équipe du n'est composée que du Healer -> Ce choix a été fait car sinon la partie dure trop longtemps
                            ((MonstreSoigneur) monstre).soigner(currentPlayer); // On soigne le joueur
                        } else { // Sinon on heal un allié
                            ((MonstreSoigneur) monstre).soigner(choisirAleatoireAvecExclusion(currentPlayer.getEquipe(), monstre));
                        }
                    } else if (monstre.getClass().equals(MonstreProtecteur.class)) {
                        if (!currentPlayer.isProtected() && !((MonstreProtecteur) monstre).isProtecting()) { // Si le champion n'est pas protégé on le protège en priorité
                            ((MonstreProtecteur) monstre).proteger(currentPlayer);
                        } else if (!((MonstreProtecteur) monstre).isProtecting() && !verifierClasse(currentPlayer.getEquipe(), MonstreProtecteur.class)) { // Sinon on protège un Monstre allié
                            ArrayList<Monstre> MonstreProteable = new ArrayList<>();
                            for (Monstre monstreACheck : currentPlayer.getEquipe()) {
                                if (!monstreACheck.isBuffed() && !monstreACheck.getClass().equals(MonstreProtecteur.class))
                                    MonstreProteable.add(monstreACheck);
                            }
                            if(!MonstreProteable.isEmpty())
                                ((MonstreProtecteur) monstre).proteger(choisirAleatoire(MonstreProteable));
                        } else logger.info(monstre.getNom()+" protège déjà une entité.");
                    }
                    if (enemyChamp.getPv() < 0) // Si l'ennemi est mort, on arrête le jeu
                        break;
                }
            } else
                logger.info("Il n'y a pas de monstres dans l'équipe de "+currentPlayer.getNom()+" on passe au tour suivant");
            // Partie 4 : On change le joueur du prochain tour
            if (nextPlayer == 0) {
                nextEnemy = 0;
                nextPlayer = 1;
            } else {
                nextEnemy = 1;
                nextPlayer = 0;
            }
        }

        if (champ1.getPv() == 0)
            logger.info(champ2.getNom()+" gagne la partie !");
        else logger.info(champ1.getNom()+" gagne la partie !");
    }

    // Ensemble de méthodes permettant de générer des sélections aléatoires selon des critères
    public static <T> T choisirAleatoire(ArrayList<T> liste) {
        // Vérifier si la liste n'est pas vide
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide ou nulle.");
        }

        // Générer un index aléatoire
        Random random = new Random();
        int indexAleatoire = random.nextInt(liste.size());
        return liste.get(indexAleatoire);
    }

    public static <T> T choisirAleatoireAvecExclusion(ArrayList<T> liste, T objetExclu) throws Exception {
        // Vérifier si la liste n'est pas vide
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide ou nulle.");
        }

        // Générer un index aléatoire
        Random random = new Random();
        int indexAleatoire;

        // Relancer si l'objet aléatoire est le même que l'objet à exclure
        if (liste.size() != 1) {
            do {
                indexAleatoire = random.nextInt(liste.size());
            } while (liste.get(indexAleatoire).equals(objetExclu));
        } else throw new Exception("La liste ne contient qu'un élément, on ne peut pas en choisir d'autre");

        // Retourner l'objet correspondant à l'index aléatoire
        return liste.get(indexAleatoire);
    }

    public static <T> T choisirAleatoireAvecExclusionDeClasse(ArrayList<T> liste, Class<?> classeExclue) {
        // Vérifier si la liste n'est pas vide
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide ou nulle.");
        }

        // Générer un index aléatoire
        Random random = new Random();
        int indexAleatoire;

        // Relancer si la classe la plus basse de l'objet aléatoire est la même que la classe à exclure
        do {
            indexAleatoire = random.nextInt(liste.size());
        } while (classeExclue.isInstance(liste.get(indexAleatoire)));

        // Retourner l'objet correspondant à l'index aléatoire
        return liste.get(indexAleatoire);
    }

    public static <T> boolean verifierClasse(ArrayList<T> liste, Class<?> classeExclue) {
        // Vérifier si la liste ne contient que des objets de la classe spécifiée
        return liste.stream().allMatch(classeExclue::isInstance);
    }
}
