/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leclaironraporteur;

import java.io.Serializable;
import java.util.*;
import java.io.*;

/**
 *
 * @author mrpar
 */
public class News implements Identifiable, Serializable {
    private int id;
    private String titre;
    private String texte;
    private Categorie categorie;
    private Source source;
    private String nom_journaliste;
    private Date date;
    private boolean important;
    private ArrayList<String> mot_cle;
    
    static int i = 0;

    public News() {
        
        i++;
        id = i;
    }
    
    
    public int getId(){return id;}
    public void setId(int i) {id=i;}
    public String getTitre() {return titre;}
    public void setTitre(String s) {titre=s;}
    public Categorie getCategorie() {return categorie;}
    public void setCategorie(Categorie c) {categorie=c;}
    public Source getSource() {return source;}
    public void setSource(Source s) {source=s;}
    public String getnomJournaliste() {return nom_journaliste;}
    public void setnomJournaliste(String i) {nom_journaliste=i;}
    public Date getDate() {return date;}
    public void setDate(Date d) {date=d;}
    public boolean isImportant() {return important;}
    public boolean getImportant() {return important;}
    public void setImportant(boolean b) {important=b;}
    public ArrayList<String> getMotCle() {return mot_cle;}
    public void setMotCle(ArrayList<String> s) {mot_cle=s;}
    public String getText(){return texte;}
    public void setText(String t) {texte=t;}

    @Override
    public String toString()
    {
         return getTitre()+"-"+getText()+"-"+getCategorie().getLibelle()+"-"+getnomJournaliste()+"-"+getImportant();
    }
    
    public void fromString(String s)
    {
        String[] tmp = s.split("-");
        
        setTitre(tmp[0]);
        setText(tmp[1]);
        setCategorie(new Categorie(tmp[2]));
        switch(tmp[2])
        {
            case "sport" :  setCategorie(Categorie.SPORT);
                            break;
            case "international" :  setCategorie(Categorie.INTERNATIONAL);
                                    break;
            case "ragots" : setCategorie(Categorie.RAGOT);
                            break;
            case "politique" :  setCategorie(Categorie.POLITIQUE);
                                break;                                
        }
        setnomJournaliste(tmp[3]);
        if(tmp[4].equals("true"))
        {
            setImportant(true);
        }
        else
        {
            setImportant(false);
        }
        setMotCle(mot_cle);
    }
}
