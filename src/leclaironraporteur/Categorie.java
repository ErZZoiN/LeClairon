/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leclaironraporteur;

import java.io.Serializable;
import java.io.*;

/**
 *
 * @author mrpar
 */
public class Categorie implements Serializable {
    private String libelle;
    
    public Categorie(String s)
    {
        libelle=s;
    }

    public String getLibelle() 
    {
        return libelle;
    }
    
    static Categorie POLITIQUE = new Categorie("politique");
    static Categorie SPORT = new Categorie("sport");
    static Categorie INTERNATIONAL = new Categorie("international");
    static Categorie RAGOT = new Categorie("ragot");
}
