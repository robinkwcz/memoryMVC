package com;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VueCarte extends JLabel implements Observateur {

    private Carte carte; //carte associer a la vuecarte
    private int indexCarte; //index de la carte dans le jeu memory
    /**
     * constructeur de VueCarte
     * @param i index de la carte dans le jeu
     * @param c carte associee a la vuecarte
     */
    public VueCarte(int i, Carte c){
        super();
        indexCarte = i;
        carte = c;
        this.setImage();
    }

    /**
     * met a jour l'icone de la vuecarte
     */
    public void setImage() {
        String chemin;
        if(carte.isVisible()){
            chemin = "img/" + carte.getRepertoire() + "/im" +carte.getNum()+".png";
        }
        else{
            chemin = "img/" + carte.getRepertoire() + "/fond.png";
        }
        this.setIcon(new ImageIcon(chemin));
    }

    /**
     * actualise la texture de la vuecarte
     */
    @Override
    public void actualiser(Sujet s) {
		Modele m = (Modele)s;
        this.carte = m.getCartes().get(indexCarte);
        if(m.getNbCoupsJoues() >= Modele.NB_COUPS_MAX){
            this.carte.setVisible(true);
        }
        else{
            this.setImage();
        }
        this.setImage();
    }

    /**
     * @getter
     * @return la carte associee a la vuecarte
     */
    public Carte getCarte(){
        return carte;
    }

    /**
     * @getter
     * @return l'index de la carte associee a la vuecarte dans la liste des cartes du modele
     */
    public int getIndexCarte(){
        return indexCarte;
    }

    /**
     * modifie la carte associee a la vuecarte
     * @param c nouvelle carte associee
     */
    public void setCarte(Carte c){
        carte = c;
    }

}
