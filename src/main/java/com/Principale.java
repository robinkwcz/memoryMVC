package com;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Principale {

	public static void main(String[] args) {

		Modele modele = new Modele();

		/**********************************
		* Création des bords des composants
		***********************************/
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border compound     = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel); 
		
		
		/*******************************************************************
		* Le JPanel plateau au nord dans lequel les cartes sont affichees
		* les JLabel avec une ImageIcon associee a chaque carte
		* Le choix du jeu de carte est fait selon la valeur de répertoire
		********************************************************************/
		JPanel plateau =new JPanel();
		plateau.setBorder(compound);
		plateau.setLayout(new GridLayout(4, 5));
		plateau.setSize(120 * 5, 120 * 4);
		
		//Création des JLabel associés aux cartes - affichage dans le JPanel Plateau
		for (int i = 0; i < 20; i++) {
			Carte c = modele.getCartes().get(i);
			VueCarte vc = new VueCarte(i, c);
			plateau.add(vc); //association du fichier image avec le JLabel avec la classe ImageIcon
			modele.enregistrerObservateur(vc);
			vc.addMouseListener(new ControleurSouris(modele));
		}		

		
		/********************************************************************
		* Le JPanel panneauScore au centre de l'IG contenant des informations
		* sur le nombre de coups joues et le nombre de paires decouvertes
		********************************************************************/
		JPanel panneauScore= new JPanel(new GridLayout(2,1));
		
		JLabel nbCoups=new VueNbCoups();
		nbCoups.setBorder(compound);
		panneauScore.add(nbCoups);
		modele.enregistrerObservateur((Observateur)nbCoups);
	
		JLabel nbPaires=new VueNbPaires();
		nbPaires.setBorder(compound);
		panneauScore.add(nbPaires);
		modele.enregistrerObservateur((Observateur)nbPaires);
				
		
		/********************************************************************
		* Le JPanel panneauChoix au sud de l'IG contenant les 4 boutons
		********************************************************************/
		JPanel panneauChoix=new JPanel();		

		JButton boutonSmiley = new JButton("Smileys");
		boutonSmiley.addActionListener(new ControleurBoutons(modele));
		panneauChoix.add(boutonSmiley);
		
		JButton boutonFruits = new JButton("Fruits");
		boutonFruits.addActionListener(new ControleurBoutons(modele));
		panneauChoix.add(boutonFruits);
		
		JButton boutonCacher = new JButton("Cacher");
		boutonCacher.addActionListener(new ControleurBoutons(modele));
		panneauChoix.add(boutonCacher);

		JButton boutonMelanger = new JButton("Melanger");
		boutonMelanger.addActionListener(new ControleurBoutons(modele));
		panneauChoix.add(boutonMelanger);
		
	 
		/**************************************
		* Construction de l'IG dans une JFrame	
		***************************************/	 
		JFrame frame=new JFrame("Memory MVC");
		frame.getContentPane().setBackground(Color.BLUE);	 
		
		frame.add(plateau,BorderLayout.NORTH);
		frame.add(panneauScore,BorderLayout.CENTER);
		frame.add(panneauChoix, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}

}
