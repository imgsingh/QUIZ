/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.kbc;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author
 */
public class mainclass extends javax.swing.JFrame {

    /**
     * Creates new form mainclass
     */
    public mainclass() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbplay = new javax.swing.JButton();
        jbhighscores = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jlbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz Application");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbplay.setText("Play");
        jbplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbplayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbplayMouseExited(evt);
            }
        });
        jbplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbplayActionPerformed(evt);
            }
        });
        getContentPane().add(jbplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jbhighscores.setText("View Highscores");
        jbhighscores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbhighscoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbhighscoresMouseExited(evt);
            }
        });
        jbhighscores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbhighscoresActionPerformed(evt);
            }
        });
        getContentPane().add(jbhighscores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        jButton2.setText("Exit");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        jlbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/kbc/knowledge.jpg"))); // NOI18N
        getContentPane().add(jlbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbplayActionPerformed
        // TODO add your handling code here:
        questionsgui quesobj = new questionsgui();
        this.setVisible( false );
        quesobj.setVisible( true );
    }//GEN-LAST:event_jbplayActionPerformed

    private void jbhighscoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbhighscoresActionPerformed
        // TODO add your handling code here:
        highscores scoreobj = new highscores();
  scoreobj.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        scoreobj.setVisible(true);
    }//GEN-LAST:event_jbhighscoresActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbplayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbplayMouseEntered
        // TODO add your handling code here:
        jbplay.setForeground(Color.WHITE);
        jbplay.setBackground(new Color(0,102,0));
    }//GEN-LAST:event_jbplayMouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(Color.WHITE);
        jButton2.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jbplayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbplayMouseExited
        // TODO add your handling code here:
        jbplay.setForeground(Color.BLACK);
        jbplay.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jbplayMouseExited

    private void jbhighscoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbhighscoresMouseEntered
        // TODO add your handling code here:
        jbhighscores.setForeground(Color.WHITE);
        jbhighscores.setBackground(new Color(0,102,0));
    }//GEN-LAST:event_jbhighscoresMouseEntered

    private void jbhighscoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbhighscoresMouseExited
        // TODO add your handling code here:
        jbhighscores.setForeground(Color.BLACK);
        jbhighscores.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jbhighscoresMouseExited

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLACK);
        jButton2.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jButton2MouseExited

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
            java.util.logging.Logger.getLogger(mainclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainclass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jbhighscores;
    private javax.swing.JButton jbplay;
    private javax.swing.JLabel jlbackground;
    // End of variables declaration//GEN-END:variables
}
