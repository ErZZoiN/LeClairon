/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leclaironraporteur;

import java.io.Serializable;

/**
 *
 * @author mrpar
 */
public final class Journaliste extends Personne implements Source {
    private int press_card;
    
    Journaliste(String n, String p, int press)
    {
        super(n, p);
        setPresse(press);
    }

    public Journaliste(String n)
    {
        super(n);
    }
    
    
    
    public int getPresse() {return press_card;}
    public void setPresse(int i) {press_card=i;}
}
