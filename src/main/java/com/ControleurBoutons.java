package com;

import java.awt.event.*;

import javax.swing.JButton;

public class ControleurBoutons implements ActionListener {

    private Modele modele; //modele controle par les boutons

    public ControleurBoutons(Modele m){
        modele = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        String action = b.getText();
        switch (action) {
            case "Smileys":
                modele.changerRepertoire("smiley"); //on change le repertoire des cartes en smiley
                break;
            case "Fruits":
                modele.changerRepertoire("fruits"); //on change le repertoire des cartes en fruits
                break;
            case "Cacher":
                modele.cacherCartes(); //lecartes sont cachées
                break;
            case "Melanger":
                modele.melangerCartes(); //les cartes sont mélangées
                break;
            default:
                break;
        }
        
    }
    
}
