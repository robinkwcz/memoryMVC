package com;

public class Carte {
	private boolean visible; // false=cachee true=visible
	private int num; 		 // numero du fichier image
	private String repertoire; // repertoire de l'image

	public Carte(int n) {
		this.num = n;
		this.visible = false;    //--> A METTRE A false POUR LE JEU
		this.repertoire = "fruits"; //images par defaut au lancement du jeu
	}

	/**
	 * @getter
	 * @return true si carte visible
	 */
	public boolean isVisible() {
		return this.visible;
	}

	/**
	 * @setter
	 * @param visible nouveau statut de visibilite de la carte
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @getter
	 * @return numero de la carte ou -1 si la carte est retounee
	 */
	public int getNum() {
		if(visible){
			return num;
		}
		else{
			return -1;
		}
	}

	/**
	 * @setter
	 * @param n nouveau numero de la carte
	 */
	public void setNum(int n) {
		this.num = n;
	}

	/**
	 * @getter
	 * @return le repertoire de l'image de la carte
	 */
	public String getRepertoire() {
		return repertoire;
	}

	/**
	 * @setter
	 * @param r nouveau repertoire de l'image de la carte
	 */
	public void setRepertoire(String r){
		this.repertoire = r;
	}
}
