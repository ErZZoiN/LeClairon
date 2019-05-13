/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leclaironraporteur;

/**
 *
 * @author mrpar
 */
public abstract class Personne implements Identifiable {
    private String nom;
    private String prenom;
    private int id_card;
    
    Personne()
    {
        setNom("");
        setPrenom("");
        setId(0);
    }
    
    Personne(String n, String p)
    {
        setNom(n);
        setPrenom(p);
        setId(0);
    }
    
    Personne(String n)
    {
        setNom(n);
        setPrenom("");
        setId(0);
    }
    
    public String getNom() {return nom;}
    public void setNom(String n) {nom=n;}
    
    public String getPrenom() {return prenom;}
    public void setPrenom(String n) {prenom=n;}
    
    @Override
    public int getId() {return id_card;}
    @Override
    public void setId(int i) {id_card=i;}
}
