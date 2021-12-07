package com;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;

public class VueNbCoups extends JLabel implements Observateur {

    public VueNbCoups(){
        super(" Nombre de coups joués : 0 ",JLabel.CENTER);
        this.setPreferredSize(new Dimension(605,55));
		this.setOpaque(true);
		this.setForeground(Color.blue);
    }

    /**
     * actualise la vue
     * @param s le sujet observé
     */
    @Override
    public void actualiser(Sujet s) {
        Modele m = (Modele) s;
        if(m.getNbPairesTrouvees() == 10){
            this.setText("FIn de la partie ! Nombre de coups joués : " + m.getNbCoupsJoues());
        }else{
            if(m.getNbCoupsJoues() >= Modele.NB_COUPS_MAX){
                this.setText("Perdu ! Nombre de coups joués : " + m.getNbCoupsJoues());
            }else{
                this.setText("Nombre de coups joués : " + m.getNbCoupsJoues());
            }
        }
    }
    
}
