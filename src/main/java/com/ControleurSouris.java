package com;

import java.awt.event.*;

public class ControleurSouris implements MouseListener{

    private Modele modele; //modele controle par la souris

    public ControleurSouris(Modele m){
        modele = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        VueCarte vc = (VueCarte) e.getSource();
        if(vc.getCarte().isVisible() == false){ //si la carte est deja retournee, on ne fait rien
            modele.retournerCarte(vc.getIndexCarte()); //on retourne la carte cliquee
        }  
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
