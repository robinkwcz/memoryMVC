package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Modele implements Sujet{
    private List<Carte> cartes; //liste des cartes du jeu memory
    private List<Observateur> observateurs; //liste des observateurs du jeu memory
    private Carte carteprecedente; //carte retournee au coup precedent
    private Carte carteprecedente2; //carte retournee il y a 2 coups
    private int nbCoupsJoues; //nombre de coups joues depuis le debut de la partie
    private int nbPairesTrouvees; //nombre de paires trouvees depuis le debut de la partie

    public static final int NB_COUPS_MAX = 20; //regle qui fixe le nombre de coups maximum par partie avant de perdre

    public Modele(){
        cartes = new ArrayList<Carte>();
        for (int i = 0; i < 20; i++) {
            cartes.add(new Carte((int)i/2));
        }
        observateurs = new ArrayList<Observateur>();
        carteprecedente = null;
        nbCoupsJoues = 0;
        nbPairesTrouvees = 0;
        Collections.shuffle(cartes); //les cartes sont melangees au debut de la partie
    }
    
    /**
     * methode qui permet de changer les images des cartes du jeu
     * @param r nouveau repertoire de cartes
     */
    public void changerRepertoire(String r){
        for (Carte carte : cartes) {
            carte.setRepertoire(r);
        }
        this.notifierObservateurs();
    }

    /**
     * methode qui retourne la carte a la position i
     * @param i position de la carte dans la liste
     */
    public void retournerCarte(int i){
        cartes.get(i).setVisible(true);
        if(carteprecedente == null){
            //cas ou aucune carte n'est retournee
            carteprecedente = cartes.get(i);
        }else{
            if(carteprecedente2 == null){
                //cas ou une seule carte est retournee
                if(cartes.get(i).getNum() == carteprecedente.getNum()){
                    //paire trouvee
                    carteprecedente = null;
                    carteprecedente2 = null;
                    nbPairesTrouvees++;
                }else{
                    //paire non trouvee
                    carteprecedente2 = carteprecedente;
                    carteprecedente = cartes.get(i);
                }
                nbCoupsJoues++;
            }
            else{
                //cas ou deux cartes differentes sont retournees
                carteprecedente.setVisible(false);
                carteprecedente2.setVisible(false);
                carteprecedente = cartes.get(i);
                carteprecedente2 = null;
            }
        }
        this.notifierObservateurs();
    }

    /**
     * methode qui cache les cartes du jeu et reset les scores de la partie
     */
    public void cacherCartes(){
        for (Carte carte : cartes) {
            carte.setVisible(false);
        }
        carteprecedente = null;
        nbCoupsJoues = 0;
        nbPairesTrouvees = 0;
        this.notifierObservateurs();
    }

    /**
     * methode qui melange les cartes et les cache pour recommencer une partie
     */
    public void melangerCartes(){
        Collections.shuffle(cartes);
        this.cacherCartes();
        this.notifierObservateurs();
    }

    /**
     * @getter
     * @return la liste des cartes du jeu memory
     */
    public List<Carte> getCartes(){
        return cartes;
    }

    /**
     * @getter
     * @return le nombre de coups joues depuis le debut de la partie
     */
    public int getNbCoupsJoues(){
        return nbCoupsJoues;
    }

    /**
     * @getter
     * @return le nombre de paires trouvees depuis le debut de la partie
     */
    public int getNbPairesTrouvees(){
        return nbPairesTrouvees;
    }

    /**
     * methode qui enregistre un observateur dans la liste des observateurs du modele
     */
    @Override
    public void enregistrerObservateur(Observateur o) {
        observateurs.add(o);
    }

    /**
     * methode qui supprime un observateur de la liste des observateurs du modele
     */
    @Override
    public void supprimerObservateur(Observateur o) {
        observateurs.remove(o);
    }

    /**
     * methode qui notifie tous les observateurs du modele
     */
    @Override
    public void notifierObservateurs() {
        for (Observateur o : observateurs) {
            o.actualiser(this);
        }
        
    }
    /**
     * methode qui retourne toutes les cartes du jeu pour afficher la solution en cas de défaite
     */
    public void retournerTout() {
        for (int i = 0; i < cartes.size(); i++) {
            cartes.get(i).setVisible(true);
        }
        this.notifierObservateurs();
    }

    
}
