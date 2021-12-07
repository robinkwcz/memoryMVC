package com;

public interface Sujet {
    /**
     * Ajoute un observateur au sujet
     * @param o l'observateur a ajouter
     */
    public void enregistrerObservateur(Observateur o);
    /**
     * Supprime un observateur du sujet
     * @param o l'observateur a supprimer
     */
    public void supprimerObservateur(Observateur o);
    /**
     * Notifie tous les observateurs du sujet
     */
    public void notifierObservateurs();
}
