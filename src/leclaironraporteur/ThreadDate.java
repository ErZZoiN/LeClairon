package leclaironraporteur;

import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Locale;

public class ThreadDate 
{
    private boolean activation;
    private MainWindow mw; 
    
    private int formatdate;
    private int formatheure;
    private Locale formatpays;
    
    public void setActivation(boolean tmp){activation = tmp;}
    public boolean getActivation(){ return activation;}
    public void setFenetreSallePresse(MainWindow tmp){mw = tmp;}
    public MainWindow getFenetreSallePresse(){ return mw;}
    
    public void setFormatDate(int tmp){formatdate = tmp;}
    public void setFormatHeure(int tmp){formatheure = tmp;}   
    public void setFormatLocale(Locale tmp){formatpays = tmp;}   

    public ThreadDate(boolean acti, MainWindow tmp2)
    {
        setActivation(acti);
        setFenetreSallePresse(tmp2); 
        setFormatDate(DateFormat.SHORT);
        setFormatHeure(DateFormat.MEDIUM);
        setFormatLocale(Locale.FRANCE);
        datecourrante();
    }
    
    /*  Thread qui va s'exécuter en même temps que la fenêtre principale et écrire sur celle-ci
        toutes les secondes afin de rafraichir l'heure. Ceci tout en respectant le format qui
        sera défini dans la fenêtre prévue à cet effet */
    public void datecourrante()
    {
        Thread clock = new Thread()
        {
            @Override
            public void run()
            {
                while(activation == true)
                {
                    Date date = new Date();                   
                    String maDate = DateFormat.
                    getDateTimeInstance(formatdate,formatheure,formatpays).format(date);  // On donne le format désiré à la date
                    
                    mw.setDate(maDate);

                    try{sleep(1000);} // On rafraichit toutes les secondes
                    catch (InterruptedException ex){Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);}
                }
            }
        };
        clock.start();
    }    
}
