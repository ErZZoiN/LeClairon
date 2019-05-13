/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leclaironraporteur;

import claironBeans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import java.util.concurrent.TimeUnit;
import network.NetworkBasicClient;
import network.NetworkBasicServer;

/**
 *
 * @author mrpar
 */
public class MainWindow extends javax.swing.JFrame implements NotifyNewsListener {
    
    private static final String fichierListeNews = "ListeNews.dat";
    
    private javax.swing.DefaultComboBoxModel comboBoxNewsModel;
    private javax.swing.DefaultComboBoxModel comboBoxReceptionModel;
    private Journaliste utilisateur;
    private Properties logins;
    private ArrayList<News> listeNews;
    private ArrayList<News> listeTemp;
    private NetworkBasicServer basicServer;
    private PresseWindow presseWindow;
    private NetworkBasicClient basicClient;
    private ArrayList<NotifyNewsListener> mailinglist;

    
    ThreadDate td;
    
    private DefaultListModel modelinternationale = new DefaultListModel();
    private DefaultListModel modelpolitique = new DefaultListModel();
    private DefaultListModel modelsports = new DefaultListModel();
    private DefaultListModel modelragots = new DefaultListModel();
    
    public DefaultListModel getListInterModel() {return modelinternationale;}
    public DefaultListModel getListPolModel() {return modelpolitique;}
    public DefaultListModel getListSportModel() {return modelsports;}
    public DefaultListModel getListRagotModel() {return modelragots;}
    
    public NetworkBasicServer getBasicServer() {return basicServer;}
    public void setBasicServer(NetworkBasicServer nbs){basicServer=nbs;}
    
    public void setListInterModel(DefaultListModel dlm) {modelinternationale = dlm;}
    public void setListPolModel(DefaultListModel dlm) {modelpolitique = dlm;}
    public void setListSportModel(DefaultListModel dlm) {modelsports = dlm;}
    public void setListRagotModel(DefaultListModel dlm) {modelragots = dlm;}
    
    public DefaultComboBoxModel getComboBoxNewsModel() {return comboBoxNewsModel;}
    public DefaultComboBoxModel getComboBoxReceptionModel() {return comboBoxReceptionModel;}
    public void setComboBoxNewsModel(DefaultComboBoxModel dcbm) {comboBoxNewsModel=dcbm;}
    public void setComboBoxReceptionModel(DefaultComboBoxModel dcbm) {comboBoxReceptionModel=dcbm;}
    
    public Journaliste getUtilisateur() {return utilisateur;}
    public void setUtilisateur(Journaliste j) {utilisateur=j;}
    public Properties getLogins(){return logins;}
    
    public ArrayList<News> getListeNews() {return listeNews;}
    public void setListeNews(ArrayList<News> a){listeNews=a;}
    
    public ArrayList<News> getListeTemp() {return listeTemp;}
    public void setListeTemp(ArrayList<News> a){listeTemp=a;}
    
    public PresseWindow getPresseWindow(){return presseWindow;}
    public void setPResseWindow(PresseWindow pw){presseWindow = pw;}
    
    public ArrayList<NotifyNewsListener> getMailingList(){return mailinglist;}
    public void setMailingList(ArrayList<NotifyNewsListener> a){mailinglist = a;}
    
    public NetworkBasicClient getNetworkBasicClient(){return basicClient;}
    public void setNetworkBasicClient(NetworkBasicClient nbc){basicClient=nbc;}
    
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow(String p, String n, Properties h) {
        initComponents();
        
        NetworkBasicServer nbs = new NetworkBasicServer(50002, checkBoxNewsRecue);
        setBasicServer(nbs);
        
        ArrayList<NotifyNewsListener> blou = new ArrayList<NotifyNewsListener>();
        setMailingList(blou);
                
        listeNews=new ArrayList<News>();
        listeTemp=new ArrayList<News>();
        
        loadNews(System.getProperty("user.dir") + System.getProperty("file.separator") + fichierListeNews);
        updateTextArea();
        
        logins=h;
        Journaliste jour = new Journaliste(n, p, 0);
        setUtilisateur(jour);
        nomJournaliste.setText(getUtilisateur().getPrenom() + " " + getUtilisateur().getNom());
        
        setComboBoxNewsModel((DefaultComboBoxModel)comboBoxNews.getModel());
        setComboBoxReceptionModel((DefaultComboBoxModel)comboBoxRec.getModel());
                
        list_inter.setModel(modelinternationale);
        list_sport.setModel(modelsports);
        list_pol.setModel(modelpolitique);
        list_ragot.setModel(modelragots);
        
        ImageIcon image = new ImageIcon("images/test.png");
        labelImage.setText("");
        labelImage.setIcon(image);
        
        td = new ThreadDate(true, this); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButtons = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        nomJournaliste = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxNews = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ajouterNews = new javax.swing.JTextField();
        traiter = new javax.swing.JButton();
        ajouter = new javax.swing.JButton();
        radioInternationales = new javax.swing.JRadioButton();
        radioViePolitique = new javax.swing.JRadioButton();
        radioInfosSports = new javax.swing.JRadioButton();
        radioRagots = new javax.swing.JRadioButton();
        editer = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        labelImage = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        list_inter = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        list_sport = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        list_ragot = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        list_pol = new javax.swing.JList<>();
        label_date = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        checkBoxNewsRecue = new javax.swing.JCheckBox();
        buttonLireNews = new javax.swing.JButton();
        buttonConfirmerReception = new javax.swing.JButton();
        buttonEnvoyerMessage = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboBoxRec = new javax.swing.JComboBox<>();
        menu = new javax.swing.JMenuBar();
        menuUtilisateurs = new javax.swing.JMenu();
        menuUtilisateursLogin = new javax.swing.JMenuItem();
        menuUtilisateursLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuUtilisateursNouveau = new javax.swing.JMenuItem();
        menuUtilisateursListe = new javax.swing.JMenuItem();
        menuConnexions = new javax.swing.JMenu();
        menuConnexionsDemarrerReception = new javax.swing.JMenuItem();
        menuConnexionsArreterReceptions = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuConnexionsListePorts = new javax.swing.JMenuItem();
        menuConnexionsListeMessages = new javax.swing.JMenuItem();
        menuRecherches = new javax.swing.JMenu();
        menuRecherchesCategorie = new javax.swing.JMenuItem();
        menuRecherchesMotCle = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuRecherchesNewsPeople = new javax.swing.JMenuItem();
        menuAide = new javax.swing.JMenu();
        menuAideParametre = new javax.swing.JMenuItem();
        menuAideLog = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuAideAPropos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fenêtre Salle de Presse");

        jLabel1.setText("Journaliste : ");

        nomJournaliste.setEditable(false);
        nomJournaliste.setText("Nom_journaliste");
        nomJournaliste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomJournalisteActionPerformed(evt);
            }
        });

        jLabel2.setText("Nous sommes le : ");

        jLabel3.setText("News reçues :");

        comboBoxNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNewsActionPerformed(evt);
            }
        });

        jLabel4.setText("Ajouter news :");

        ajouterNews.setText("ajouter_news");
        ajouterNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterNewsActionPerformed(evt);
            }
        });

        traiter.setText("Traiter");
        traiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traiterActionPerformed(evt);
            }
        });

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        radioButtons.add(radioInternationales);
        radioInternationales.setText("Internationales");

        radioButtons.add(radioViePolitique);
        radioViePolitique.setText("Vie Politique");

        radioButtons.add(radioInfosSports);
        radioInfosSports.setText("Infos sports");
        radioInfosSports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioInfosSportsActionPerformed(evt);
            }
        });

        radioButtons.add(radioRagots);
        radioRagots.setText("Ragots et potins");

        editer.setText("Editer");
        editer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editerActionPerformed(evt);
            }
        });

        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(list_inter);

        jScrollPane7.setViewportView(list_sport);

        jScrollPane8.setViewportView(list_ragot);

        jScrollPane9.setViewportView(list_pol);

        checkBoxNewsRecue.setText("News recues !");
        checkBoxNewsRecue.setEnabled(false);
        checkBoxNewsRecue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNewsRecueActionPerformed(evt);
            }
        });

        buttonLireNews.setText("Lire la news");
        buttonLireNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLireNewsActionPerformed(evt);
            }
        });

        buttonConfirmerReception.setText("Confirmer Réception");
        buttonConfirmerReception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmerReceptionActionPerformed(evt);
            }
        });

        buttonEnvoyerMessage.setText("Envoyer un message");
        buttonEnvoyerMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnvoyerMessageActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Wide Latin", 1, 12)); // NOI18N
        jLabel5.setText("OU");

        menuUtilisateurs.setText("Utilisateurs");

        menuUtilisateursLogin.setText("Login");
        menuUtilisateursLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUtilisateursLoginActionPerformed(evt);
            }
        });
        menuUtilisateurs.add(menuUtilisateursLogin);

        menuUtilisateursLogout.setText("Logout");
        menuUtilisateursLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUtilisateursLogoutActionPerformed(evt);
            }
        });
        menuUtilisateurs.add(menuUtilisateursLogout);
        menuUtilisateurs.add(jSeparator1);

        menuUtilisateursNouveau.setText("Nouveau");
        menuUtilisateursNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUtilisateursNouveauActionPerformed(evt);
            }
        });
        menuUtilisateurs.add(menuUtilisateursNouveau);

        menuUtilisateursListe.setText("Liste");
        menuUtilisateurs.add(menuUtilisateursListe);

        menu.add(menuUtilisateurs);

        menuConnexions.setText("Connexions");

        menuConnexionsDemarrerReception.setText("Démarrer réceptions");
        menuConnexions.add(menuConnexionsDemarrerReception);

        menuConnexionsArreterReceptions.setText("Arrêter Réception");
        menuConnexions.add(menuConnexionsArreterReceptions);
        menuConnexions.add(jSeparator2);

        menuConnexionsListePorts.setText("Liste des ports");
        menuConnexions.add(menuConnexionsListePorts);

        menuConnexionsListeMessages.setText("Liste des messages reçus");
        menuConnexions.add(menuConnexionsListeMessages);

        menu.add(menuConnexions);

        menuRecherches.setText("Recherches");

        menuRecherchesCategorie.setText("Par catégorie");
        menuRecherchesCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRecherchesCategorieActionPerformed(evt);
            }
        });
        menuRecherches.add(menuRecherchesCategorie);

        menuRecherchesMotCle.setText("Par mot clé");
        menuRecherchesMotCle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRecherchesMotCleActionPerformed(evt);
            }
        });
        menuRecherches.add(menuRecherchesMotCle);
        menuRecherches.add(jSeparator3);

        menuRecherchesNewsPeople.setText("News people");
        menuRecherches.add(menuRecherchesNewsPeople);

        menu.add(menuRecherches);

        menuAide.setText("Aide");

        menuAideParametre.setText("Paramètres date");
        menuAideParametre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAideParametreActionPerformed(evt);
            }
        });
        menuAide.add(menuAideParametre);

        menuAideLog.setText("Afficher le log");
        menuAide.add(menuAideLog);
        menuAide.add(jSeparator4);

        menuAideAPropos.setText("A propos");
        menuAideAPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAideAProposActionPerformed(evt);
            }
        });
        menuAide.add(menuAideAPropos);

        menu.add(menuAide);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioInfosSports)
                .addGap(76, 76, 76)
                .addComponent(radioRagots)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomJournaliste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxNews, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(radioInternationales)))
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(ajouterNews, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ajouter)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(traiter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(supprimer))
                                    .addComponent(radioViePolitique))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(buttonConfirmerReception, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEnvoyerMessage)))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(406, 406, 406)
                                .addComponent(editer))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(checkBoxNewsRecue, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxRec, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonLireNews, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nomJournaliste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboBoxNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(traiter)
                            .addComponent(supprimer))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ajouterNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ajouter)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(label_date, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioRagots)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioInternationales)
                            .addComponent(radioViePolitique)
                            .addComponent(radioInfosSports))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addComponent(editer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxNewsRecue)
                    .addComponent(buttonLireNews)
                    .addComponent(buttonConfirmerReception)
                    .addComponent(buttonEnvoyerMessage)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void saveNews()
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + fichierListeNews));
            oos.writeObject(getListeNews());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadNews(String path)
    {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            setListeNews((ArrayList<News>)ois.readObject());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTextArea()
    {
        getListPolModel().clear();
        getListSportModel().clear();
        getListInterModel().clear();
        getListRagotModel().clear();
        
        for(int i = 0;i<getListeNews().size();i++)
        {
            switch(getListeNews().get(i).getCategorie().getLibelle())
            {
                case "politique" :  getListPolModel().addElement(getListeNews().get(i).getTitre());
                                    break;

                case "sport" :  getListSportModel().addElement(getListeNews().get(i).getTitre());
                                break;

                case "international" :  getListInterModel().addElement(getListeNews().get(i).getTitre());
                                        break;

                case "ragot" :  getListRagotModel().addElement(getListeNews().get(i).getTitre());
                                break;
            }
        }
    }
    
    public void addNotifyNewsListener(NotifyNewsListener nnl)
    {
        //La fenêtre ne peut se connecter au port que lorsque
        //celui-ci est déjà ouvert par le serveur.
        NetworkBasicClient nbc = new NetworkBasicClient("localhost", 50003);
        setNetworkBasicClient(nbc);
        getMailingList().add(nnl);
    }
    
    @Override
    public void NotifyNewsDetected(NotifyNewsEvent e)
    {
        try {
            TimeUnit.MILLISECONDS.sleep(10); // Exécution trop rapide sans un délais, on lit "RIEN"
        } catch (InterruptedException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        String message = getBasicServer().getMessage();
        if(message.equals("RIEN"))
        {
            return;
        }
        else
        {
            News ntmp = new News();
            ntmp.fromString(message);
              
            getListeTemp().add(ntmp);
            
            getComboBoxReceptionModel().addElement(ntmp.getTitre());
        }
    }

    
    private void menuUtilisateursLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUtilisateursLoginActionPerformed
        LoginWindow logwin = new LoginWindow(this);
        logwin.setVisible(true);
    }//GEN-LAST:event_menuUtilisateursLoginActionPerformed

    private void nomJournalisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomJournalisteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomJournalisteActionPerformed

    private void comboBoxNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNewsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxNewsActionPerformed

    private void ajouterNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterNewsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajouterNewsActionPerformed

    private void traiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traiterActionPerformed
        String tmp=(String)getComboBoxNewsModel().getSelectedItem();
        getComboBoxNewsModel().removeElement(getComboBoxNewsModel().getSelectedItem());
        if(tmp!=null)
        {
            TraitementWindow traitement = new TraitementWindow(tmp, this);
            traitement.setVisible(true);
        }
        else
            System.out.println("PAS D'ITEM SELECTIONNE !");
    }//GEN-LAST:event_traiterActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        getComboBoxNewsModel().addElement(ajouterNews.getText());
    }//GEN-LAST:event_ajouterActionPerformed

    private void radioInfosSportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioInfosSportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioInfosSportsActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        String tmp;
        if((tmp = (String)getComboBoxNewsModel().getSelectedItem())!=null)
            getComboBoxNewsModel().removeElement(tmp);
    }//GEN-LAST:event_supprimerActionPerformed

    private void menuUtilisateursNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUtilisateursNouveauActionPerformed
        NouveauLogWindow nlw = new NouveauLogWindow(this);
        nlw.setVisible(true);
    }//GEN-LAST:event_menuUtilisateursNouveauActionPerformed

    private void menuUtilisateursLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUtilisateursLogoutActionPerformed
        LoginWindow lw = new LoginWindow(getLogins());
        lw.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuUtilisateursLogoutActionPerformed

    private void menuAideParametreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAideParametreActionPerformed
        DateWindow dw = new DateWindow(this);
        dw.setVisible(true);
        
    }//GEN-LAST:event_menuAideParametreActionPerformed

    private void editerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editerActionPerformed

        int index;
        String tmp = new String();
        News news = new News();
        
        // On s'assure que la news soit sélectionnée dans la colonne dont le radiobutton est sélectionné
        if(list_inter.isSelectionEmpty() == false && radioInternationales.isSelected() == true)
        {
            tmp = list_inter.getSelectedValue();
            index = list_inter.getSelectedIndex();
        }
        else if(list_pol.isSelectionEmpty() == false && radioViePolitique.isSelected() == true)
        {
            tmp = list_pol.getSelectedValue();
            index = list_pol.getSelectedIndex();
        }
        else if(list_sport.isSelectionEmpty() == false && radioInfosSports.isSelected() == true)
        {
            tmp = list_sport.getSelectedValue();
            index = list_sport.getSelectedIndex();
        }
        else if(list_ragot.isSelectionEmpty() == false && radioRagots.isSelected() == true)
        {
            tmp = list_ragot.getSelectedValue();
            index = list_ragot.getSelectedIndex();
        }
        else
            return;
            
        int i = 0;
        while(!tmp.equals(listeNews.get(i).getTitre())) // On cherche la news dans le vecteur
        {
            i++;
        }
        
        news = listeNews.get(i);
        
        TraitementWindow traitement = new TraitementWindow(news, index, i, this);
        traitement.setVisible(true);
    }//GEN-LAST:event_editerActionPerformed

    private void menuAideAProposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAideAProposActionPerformed
        AboutWindow aw = new AboutWindow();
        aw.setVisible(true);
    }//GEN-LAST:event_menuAideAProposActionPerformed

    private void checkBoxNewsRecueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNewsRecueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxNewsRecueActionPerformed

    private void buttonLireNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLireNewsActionPerformed
        String tmp=(String)getComboBoxReceptionModel().getSelectedItem();
        
        for(int i = 0; i < listeTemp.size(); i++)
        {
            if(tmp.equals(listeTemp.get(i).getTitre()))
            {
                new MotResultatWindow(listeTemp.get(i)).setVisible(true);                
            }
        }
    }//GEN-LAST:event_buttonLireNewsActionPerformed

    private void menuRecherchesMotCleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRecherchesMotCleActionPerformed
        RechercheNomWindow rnw = new RechercheNomWindow(this);
        rnw.setVisible(true);
    }//GEN-LAST:event_menuRecherchesMotCleActionPerformed

    private void menuRecherchesCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRecherchesCategorieActionPerformed
        RechercheCatégorieWindow rcw = new RechercheCatégorieWindow(this);
        rcw.setVisible(true);
    }//GEN-LAST:event_menuRecherchesCategorieActionPerformed

    private void buttonConfirmerReceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmerReceptionActionPerformed
        
        String tmp=(String)getComboBoxReceptionModel().getSelectedItem();
        getComboBoxReceptionModel().removeElement(getComboBoxReceptionModel().getSelectedItem());
        
        getNetworkBasicClient().sendStringWithoutWaiting("Message reçu !");
        
        News ntmp = new News();
        for(int i = 0; i < listeTemp.size(); i++)
        {
            if(tmp.equals(listeTemp.get(i).getTitre()))
            {
                ntmp = getListeTemp().get(i);
                getListeNews().add(ntmp);
                switch(ntmp.getCategorie().getLibelle())
                {
                    case "politique" :  getListPolModel().addElement(ntmp.getTitre());
                                        break;

                    case "sport" :  getListSportModel().addElement(ntmp.getTitre());
                                    break;

                    case "international" :  getListInterModel().addElement(ntmp.getTitre());
                                            break;

                    case "ragot" :  getListRagotModel().addElement(ntmp.getTitre());
                                    break;
                }
                break;
            }
        }

        System.out.println("APRES PROB");
        
        NotifyNewsEvent nne = new NotifyNewsEvent();

        for(int j=0;j<getMailingList().size();j++)
        {
            getMailingList().get(j).NotifyNewsDetected(nne);
        }
   
    }//GEN-LAST:event_buttonConfirmerReceptionActionPerformed

    private void buttonEnvoyerMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnvoyerMessageActionPerformed
        String tmp = (String)getComboBoxReceptionModel().getSelectedItem();
        
        ReponseWindow rw = new ReponseWindow(tmp, this);
        rw.setVisible(true);
    }//GEN-LAST:event_buttonEnvoyerMessageActionPerformed

    
    private void ajouterNewsPanel(News news)
    {
        DefaultListModel dlm = new DefaultListModel();
        
        switch(news.getCategorie().getLibelle())
        {
            case "politique" :  getListPolModel().addElement(news.getTitre());
                                break;

            case "sport" :  getListSportModel().addElement(news.getTitre());
                            break;

            case "international" :  getListInterModel().addElement(news.getTitre());
                                    break;

            case "ragot" :  getListRagotModel().addElement(news.getTitre());
                            break;

        }
    }
    
    public void setDate(String date)
    {
        label_date.setText(date);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField ajouterNews;
    private javax.swing.JButton buttonConfirmerReception;
    private javax.swing.JButton buttonEnvoyerMessage;
    private javax.swing.JButton buttonLireNews;
    private javax.swing.JCheckBox checkBoxNewsRecue;
    private javax.swing.JComboBox<String> comboBoxNews;
    private javax.swing.JComboBox<String> comboBoxRec;
    private javax.swing.JButton editer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel label_date;
    javax.swing.JList<String> list_inter;
    javax.swing.JList<String> list_pol;
    javax.swing.JList<String> list_ragot;
    javax.swing.JList<String> list_sport;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAide;
    private javax.swing.JMenuItem menuAideAPropos;
    private javax.swing.JMenuItem menuAideLog;
    private javax.swing.JMenuItem menuAideParametre;
    private javax.swing.JMenu menuConnexions;
    private javax.swing.JMenuItem menuConnexionsArreterReceptions;
    private javax.swing.JMenuItem menuConnexionsDemarrerReception;
    private javax.swing.JMenuItem menuConnexionsListeMessages;
    private javax.swing.JMenuItem menuConnexionsListePorts;
    private javax.swing.JMenu menuRecherches;
    private javax.swing.JMenuItem menuRecherchesCategorie;
    private javax.swing.JMenuItem menuRecherchesMotCle;
    private javax.swing.JMenuItem menuRecherchesNewsPeople;
    private javax.swing.JMenu menuUtilisateurs;
    private javax.swing.JMenuItem menuUtilisateursListe;
    private javax.swing.JMenuItem menuUtilisateursLogin;
    private javax.swing.JMenuItem menuUtilisateursLogout;
    private javax.swing.JMenuItem menuUtilisateursNouveau;
    private javax.swing.JTextField nomJournaliste;
    private javax.swing.ButtonGroup radioButtons;
    private javax.swing.JRadioButton radioInfosSports;
    private javax.swing.JRadioButton radioInternationales;
    private javax.swing.JRadioButton radioRagots;
    private javax.swing.JRadioButton radioViePolitique;
    private javax.swing.JButton supprimer;
    private javax.swing.JButton traiter;
    // End of variables declaration//GEN-END:variables
}
