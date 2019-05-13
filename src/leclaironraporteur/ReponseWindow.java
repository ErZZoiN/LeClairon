/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leclaironraporteur;

import claironBeans.NotifyNewsEvent;
import claironBeans.NotifyNewsListener;
import java.util.ArrayList;
import network.NetworkBasicClient;

/**
 *
 * @author alexa
 */
public class ReponseWindow extends javax.swing.JFrame {

    MainWindow mw;
    private NetworkBasicClient basicClient;
    private ArrayList<NotifyNewsListener> mailinglist;
    
    public ArrayList<NotifyNewsListener> getMailingList(){return mailinglist;}
    public void setMailingList(ArrayList<NotifyNewsListener> a){mailinglist = a;}
    
    public NetworkBasicClient getNetworkBasicClient(){return basicClient;}
    public void setNetworkBasicClient(NetworkBasicClient nbc){basicClient=nbc;}
    
    public ReponseWindow() {
        initComponents();
    }
    
    public ReponseWindow(String titre, MainWindow aThis) {
        initComponents();
        labelTitre.setText(titre);
        mw = aThis;
        
        NetworkBasicClient nbc = new NetworkBasicClient("localhost", 50003);
        setNetworkBasicClient(nbc);
        
        ArrayList<NotifyNewsListener> blou = new ArrayList<NotifyNewsListener>();
        setMailingList(blou);
        
        addNotifyNewsListener(mw.getPresseWindow());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelTitre = new javax.swing.JLabel();
        TF_Rep = new javax.swing.JTextField();
        buttonEnvoyer = new javax.swing.JButton();
        buttonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Réponse");

        jLabel1.setText("News");

        jLabel2.setText("Réponse");

        labelTitre.setText("   ");

        TF_Rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_RepActionPerformed(evt);
            }
        });

        buttonEnvoyer.setText("Envoyer");
        buttonEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnvoyerActionPerformed(evt);
            }
        });

        buttonAnnuler.setText("Annuler");
        buttonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTitre, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(TF_Rep)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(buttonEnvoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buttonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelTitre))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_Rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEnvoyer)
                    .addComponent(buttonAnnuler))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF_RepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_RepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_RepActionPerformed

    public void addNotifyNewsListener(NotifyNewsListener nnl)
    {
        getMailingList().add(nnl);
    }
    
    private void buttonEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnvoyerActionPerformed
        String tmp = labelTitre.getText();
        mw.getComboBoxReceptionModel().removeElement(mw.getComboBoxReceptionModel().getSelectedItem());
        
        News ntmp = new News();
        for(int i = 0; i < mw.getListeTemp().size(); i++)
        {
            if(tmp.equals(mw.getListeTemp().get(i).getTitre()))
            {
                ntmp = mw.getListeTemp().get(i);
                mw.getListeTemp().add(ntmp);
                switch(ntmp.getCategorie().getLibelle())
                {
                    case "politique" :  mw.getListPolModel().addElement(ntmp.getTitre());
                                        break;

                    case "sport" :  mw.getListSportModel().addElement(ntmp.getTitre());
                                    break;

                    case "international" :  mw.getListInterModel().addElement(ntmp.getTitre());
                                            break;

                    case "ragot" :  mw.getListRagotModel().addElement(ntmp.getTitre());
                                    break;
                }
                break;              
            }
        }
        
        String message = TF_Rep.getText();

        basicClient.sendStringWithoutWaiting(message);

        NotifyNewsEvent nne = new NotifyNewsEvent();

        for(int j=0;j<getMailingList().size();j++)
        {
            getMailingList().get(j).NotifyNewsDetected(nne);
        }
        
        dispose();

        
    }//GEN-LAST:event_buttonEnvoyerActionPerformed

    private void buttonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulerActionPerformed
        dispose();
    }//GEN-LAST:event_buttonAnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(ReponseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReponseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReponseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReponseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReponseWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_Rep;
    private javax.swing.JButton buttonAnnuler;
    private javax.swing.JButton buttonEnvoyer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelTitre;
    // End of variables declaration//GEN-END:variables
}