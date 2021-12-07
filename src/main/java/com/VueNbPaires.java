package com;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;

public class VueNbPaires extends JLabel implements Observateur {

    public VueNbPaires(){
        super("Nombre de paires découvertes :  0 ",JLabel.CENTER);
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
            this.setText("BRAVO !");
        }else{
            if(m.getNbCoupsJoues() >= Modele.NB_COUPS_MAX){
                this.setText("Cliquez sur Melanger pour relancer une partie");
            }else{
                this.setText("Nombre de paires découvertes : " + m.getNbPairesTrouvees());
            }
        }
    }
}
