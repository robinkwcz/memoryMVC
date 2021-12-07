package com;

public interface Observateur {

    /**
     * Méthode appelée lorsqu'un observateur doit etre mis a jour.
     * @param s le sujet a qui l'observateur est associe.
     */
    public void actualiser(Sujet s);
}
