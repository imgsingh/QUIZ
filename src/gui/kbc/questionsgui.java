/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.kbc;
import database.connectdb;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import pollpkg.pollA;
import pollpkg.pollB;
import pollpkg.pollC;
import pollpkg.pollD;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author S A N D H U
 */
public class questionsgui extends javax.swing.JFrame implements Runnable
{
    static String username;
    static int i=1, money=0;
    static int vfifty=1, vaudiencepoll=1, vskipquestion=1, vredeem=1;
    static String dbchoice1, dbchoice2, dbchoice3, dbchoice4, dbans;

    static void lifelineentered( JButton jb )
    {
        jb.setBackground(new Color(102,102,0));
    }
    
    static void lifelineexited( JButton jb )
    {
        jb.setForeground(Color.BLACK);
        jb.setBackground(new Color(240,240,240));
    }
        
    static void sleep( int t )
{
     try 
           {
               t = t * 500;
	       Thread.sleep( t );   // here 500 means 1 second
           }
           catch(Exception e)
           {
	      System.out.println( e );
           }
}

    public questionsgui() {
        input_name();
        editing( i );
    }
    
    
    void input_name()
    {
       username = JOptionPane.showInputDialog(rootPane,"Enter your name to play");
       username = username.trim();
       if(username.equals(""))
       {
          JOptionPane.showMessageDialog(getRootPane(), "Please fill the name !!");
          input_name();
       }
       else{ initComponents(); }
    }
    
    void writing_scores()
    {
            try
            {
                Connection conn = connectdb.getConnection();
                
                String query1 = "insert into highscores_table Values( ?,? )" ;
                PreparedStatement ps1 =  conn.prepareStatement( query1 );
                ps1.setString( 1,username );
                ps1.setString( 2,""+money );
              
                ps1.executeUpdate();
            }
            catch(Exception e){ System.out.println(e); }
    }
    
    void moneylist()
    {
        if( money<50000 )
                {
                    jLabel1.setForeground(new Color(0,102,0));
                    jLabel2.setEnabled(true);  jLabel3.setEnabled(true); jLabel4.setEnabled(true); jLabel5.setEnabled(true); jLabel6.setEnabled(true); jLabel7.setEnabled(true); jLabel8.setEnabled(true); jLabel9.setEnabled(true); 
                }
        if( money>=50000 && money<100000 )
                {
                    jLabel2.setEnabled(true);
                    jLabel1.setEnabled(false);  jLabel2.setForeground(new Color(0,102,0));
                    jLabel3.setEnabled(true); jLabel4.setEnabled(true); jLabel5.setEnabled(true); jLabel6.setEnabled(true); jLabel7.setEnabled(true); jLabel8.setEnabled(true); jLabel9.setEnabled(true); 
                }
        if( money>=100000 && money<200000 )
                {
                    jLabel3.setEnabled(true);
                    jLabel3.setForeground(new Color(0,102,0));  jLabel2.setEnabled(false);;
                    jLabel4.setEnabled(true); jLabel5.setEnabled(true); jLabel6.setEnabled(true); jLabel7.setEnabled(true); jLabel8.setEnabled(true); jLabel9.setEnabled(true); 
                }
        if( money>=200000 && money<400000 )
                {
                    jLabel4.setEnabled(true);
                    jLabel4.setForeground(new Color(0,102,0));  jLabel3.setEnabled(false);
                     jLabel5.setEnabled(true); jLabel6.setEnabled(true); jLabel7.setEnabled(true); jLabel8.setEnabled(true); jLabel9.setEnabled(true); 
                }
        if( money>=400000 && money<800000 )
                {
                    jLabel5.setEnabled(true);
                    jLabel5.setForeground(new Color(0,102,0));  jLabel4.setEnabled(false);
                     jLabel6.setEnabled(true); jLabel7.setEnabled(true); jLabel8.setEnabled(true); jLabel9.setEnabled(true); 
                }
        if( money>=800000 && money<1600000 )
                {
                    jLabel6.setEnabled(true);
                    jLabel6.setForeground(new Color(0,102,0));  jLabel5.setEnabled(false);
                      jLabel7.setEnabled(true); jLabel8.setEnabled(true); jLabel9.setEnabled(true); 
                }
        if( money>=1600000 && money<3200000 )
                {
                    jLabel7.setEnabled(true);
                    jLabel7.setForeground(new Color(0,102,0));  jLabel6.setEnabled(false);
                    jLabel8.setEnabled(true); jLabel9.setEnabled(true); 
                }
        if( money>=3200000 && money<6400000 )
                {
                    jLabel8.setEnabled(true);
                    jLabel8.setForeground(new Color(0,102,0));  jLabel7.setEnabled(false);
                     jLabel9.setEnabled(true); 
                }
        if(  money>=6400000 &&  money<10000000  )
                {
                    jLabel9.setEnabled(true);
                    jLabel9.setForeground(new Color(0,102,0));  jLabel8.setEnabled(false);
                }
    }
    
    void editing(int start)
    {
         try
         {
                moneylist();
                
//                Image background = Toolkit.getDefaultToolkit().createImage("redeem.jpg");
//                
//             
//                Icon fiftyjpg = new ImageIcon( getClass().getResource( "fifty.jpg" ) );
//                
//                jbfifty.setIcon( fiftyjpg );
//                jbfifty.setContentAreaFilled(false);
//                jbfifty.setBorder( BorderFactory.createEmptyBorder() );
//                
//                Icon polljpg = new ImageIcon( getClass().getResource( "poll.jpg" ) );
//                jbaudiencepoll.setIcon( polljpg );
//                jbaudiencepoll.setContentAreaFilled(false);
//                jbaudiencepoll.setBorder( BorderFactory.createEmptyBorder() );
//                
//                Icon skipjpg = new ImageIcon( getClass().getResource( "skip.jpg" ) );
//                jbskip.setIcon( skipjpg );
//                jbskip.setContentAreaFilled(false);
//                jbskip.setBorder( BorderFactory.createEmptyBorder() );
//                
//                Icon redeemjpg = new ImageIcon( getClass().getResource( "redeem.jpg" ) );
//                jbredeem.setIcon( redeemjpg );
//                jbredeem.setContentAreaFilled(false);
//                jbredeem.setBorder( BorderFactory.createEmptyBorder() );
//             
                Connection conn = connectdb.getConnection();
                String query1 = String.format( "select * from questions_table where dbS_No = %d" , start );
                
                Statement sm = conn.createStatement();
                ResultSet rs = sm.executeQuery( query1 );
                while( rs.next() )
                {  
                    String dbsno = rs.getString("dbS_No");
                    String dbquestion = rs.getString("dbquestion");
                     dbchoice1 = rs.getString("dbchoice1");
                     dbchoice2 = rs.getString("dbchoice2");
                     dbchoice3 = rs.getString("dbchoice3");
                     dbchoice4 = rs.getString("dbchoice4");
                    dbans = rs.getString("dbans");
                    
                    jlquestion.setText(dbquestion);
                    jbans1.setText(dbchoice1);
                    jbans2.setText(dbchoice2);
                    jbans3.setText(dbchoice3);
                    jbans4.setText(dbchoice4);
                    
                    if( vfifty == 0 )
                    {
                        jbfifty.setEnabled(false);
                    } else{ jbfifty.setEnabled(true); }
                    
                     if( vaudiencepoll == 0 )
                    {
                        jbaudiencepoll.setEnabled(false);
                    } else{ jbaudiencepoll.setEnabled(true); }
                     
                      if( vskipquestion == 0 )
                    {
                        jbskip.setEnabled(false);
                    } else{ jbskip.setEnabled(true);   }
                     
                      if( vredeem == 0 )
                    {
                        jbredeem.setEnabled(false);
                    }
                      
     
                    
                    
                }
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbans1 = new javax.swing.JButton();
        jbans2 = new javax.swing.JButton();
        jbans3 = new javax.swing.JButton();
        jbans4 = new javax.swing.JButton();
        jbquitplaying = new javax.swing.JButton();
        jlquestion = new javax.swing.JLabel();
        jbfifty = new javax.swing.JButton();
        jbaudiencepoll = new javax.swing.JButton();
        jbskip = new javax.swing.JButton();
        jbredeem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz Application");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbans1.setText("jButton1");
        jbans1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbans1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbans1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbans1MousePressed(evt);
            }
        });
        jbans1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbans1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbans1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jbans2.setText("jButton1");
        jbans2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbans2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbans2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbans2MousePressed(evt);
            }
        });
        jbans2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbans2ActionPerformed(evt);
            }
        });
        getContentPane().add(jbans2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jbans3.setText("jButton1");
        jbans3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbans3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbans3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbans3MousePressed(evt);
            }
        });
        jbans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbans3ActionPerformed(evt);
            }
        });
        getContentPane().add(jbans3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jbans4.setText("jButton1");
        jbans4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbans4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbans4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbans4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbans4MousePressed(evt);
            }
        });
        jbans4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbans4ActionPerformed(evt);
            }
        });
        getContentPane().add(jbans4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jbquitplaying.setText("Quit Playing");
        jbquitplaying.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbquitplayingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbquitplayingMouseExited(evt);
            }
        });
        jbquitplaying.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbquitplayingActionPerformed(evt);
            }
        });
        getContentPane().add(jbquitplaying, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        jlquestion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlquestion.setForeground(new java.awt.Color(102, 255, 102));
        jlquestion.setText("Question");
        getContentPane().add(jlquestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jbfifty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/kbc/nfifty.png"))); // NOI18N
        jbfifty.setToolTipText("50-50");
        jbfifty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbfiftyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbfiftyMouseExited(evt);
            }
        });
        jbfifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfiftyActionPerformed(evt);
            }
        });
        getContentPane().add(jbfifty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 70, 50));

        jbaudiencepoll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/kbc/poll.jpg"))); // NOI18N
        jbaudiencepoll.setToolTipText("Audience Poll");
        jbaudiencepoll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbaudiencepollMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbaudiencepollMouseExited(evt);
            }
        });
        jbaudiencepoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbaudiencepollActionPerformed(evt);
            }
        });
        getContentPane().add(jbaudiencepoll, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 70, 50));

        jbskip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/kbc/skip.jpg"))); // NOI18N
        jbskip.setToolTipText("Skip current question");
        jbskip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbskipMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbskipMouseExited(evt);
            }
        });
        jbskip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbskipActionPerformed(evt);
            }
        });
        getContentPane().add(jbskip, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 70, 50));

        jbredeem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/kbc/redeem.jpg"))); // NOI18N
        jbredeem.setToolTipText("Redeem a lifeline");
        jbredeem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbredeemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbredeemMouseExited(evt);
            }
        });
        jbredeem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbredeemActionPerformed(evt);
            }
        });
        getContentPane().add(jbredeem, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 70, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("50000");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("100000");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("200000");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("400000");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("800000");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("1600000");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("3200000");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("6400000");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("10000000");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Money");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, 470));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/kbc/quizcomp.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbans1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbans1ActionPerformed
        // TODO add your handling code here:
        try
         {
             
                String dbans = "";             
                Connection conn = connectdb.getConnection();
                String query1 = String.format( "select * from questions_table where dbS_No = %d" ,i );
                
                Statement sm = conn.createStatement();
                ResultSet rs = sm.executeQuery( query1 );
                while( rs.next() )
                {  
                    dbans = rs.getString("dbans").trim();
                    String dbsno = rs.getString("dbS_No");
                    String dbquestion = rs.getString("dbquestion");
                     dbchoice1 = rs.getString("dbchoice1");
                     dbchoice2 = rs.getString("dbchoice2");
                     dbchoice3 = rs.getString("dbchoice3");
                     dbchoice4 = rs.getString("dbchoice4");
                }

                if(evt.getActionCommand().equals(dbans))
                {
                    
                    
                    if( money == 0 )
                    {    
                    money = 50000;
                    }
                    else if(money>=6400000)
                    {
                        
                        money = 10000000;
                        writing_scores();
                       JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money+ "\nYou are a Crorepati now !!!");
                       money = 0;
                       jbans1.setEnabled(true);
                       jbans2.setEnabled(true);
                       jbans3.setEnabled(true);
                       jbans4.setEnabled(true);
                       i = 1;
                       vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                       mainclass mainobj = new mainclass();
                       this.setVisible( false );
                       mainobj.setVisible( true );
                    }
                    else{ money = money*2; }
                    
                    if( money!=0 )
                    {
                    JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money);
                    }
                    jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    i++;
                    editing( i );
                }
                
                else
                {   
                   i=1;
                   vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                  JOptionPane.showMessageDialog(rootPane, "wrong ans\ntotal amount " +money);
                  jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    writing_scores();
                    money = 0;
                  mainclass mainobj = new mainclass();
                  this.setVisible(false);
                  mainobj.setVisible(true);
                }
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }//GEN-LAST:event_jbans1ActionPerformed

    private void jbans4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbans4ActionPerformed
        // TODO add your handling code here:
        try
         {
             
                String dbans = "";             
                Connection conn = connectdb.getConnection();
                String query1 = String.format( "select * from questions_table where dbS_No = %d" ,i );
                
                Statement sm = conn.createStatement();
                ResultSet rs = sm.executeQuery( query1 );
                while( rs.next() )
                {  
                    dbans = rs.getString("dbans").trim();
                    String dbsno = rs.getString("dbS_No");
                    String dbquestion = rs.getString("dbquestion");
                     dbchoice1 = rs.getString("dbchoice1");
                     dbchoice2 = rs.getString("dbchoice2");
                     dbchoice3 = rs.getString("dbchoice3");
                     dbchoice4 = rs.getString("dbchoice4");
                }

                if(evt.getActionCommand().equals(dbans))
                {
                    
                    
                    if( money == 0 )
                    {    
                    money = 50000;
                    }
                     else if(money>=6400000)
                    {
                        
                        money = 10000000;
                        writing_scores();
                       JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money+ "\nYou are a Crorepati now !!!");
                       money = 0;
                       jbans1.setEnabled(true);
                       jbans2.setEnabled(true);
                       jbans3.setEnabled(true);
                       jbans4.setEnabled(true);
                       i = 1;
                       vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                       mainclass mainobj = new mainclass();
                       this.setVisible( false );
                       mainobj.setVisible( true );
                    }
                    else{ money = money*2; }
                    
                    if( money!=0 )
                    {
                    JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money);
                    }
                    jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    i++;
                    editing( i );
                }
                
                else
                {   
                   i=1;
                   vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                  JOptionPane.showMessageDialog(rootPane, "wrong ans\ntotal amount " +money);
                  jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    writing_scores();
                    money = 0;
                  mainclass mainobj = new mainclass();
                  this.setVisible(false);
                  mainobj.setVisible(true);
                }
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }//GEN-LAST:event_jbans4ActionPerformed

    private void jbquitplayingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbquitplayingActionPerformed
        // TODO add your handling code here:
        try
             {
                 
                 i=1;
                 vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                 writing_scores();
                 money = 0;
                 mainclass mainobj = new mainclass();
                 this.setVisible( false );
                 mainobj.setVisible( true );
             }
             catch(Exception e)
             {
                System.out.println(e);
             }
    }//GEN-LAST:event_jbquitplayingActionPerformed

    private void jbfiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbfiftyActionPerformed
        // TODO add your handling code here:
        try
         {
                vfifty = 0;
                String dbans = "";             
                Connection conn = connectdb.getConnection();
                String query1 = String.format( "select * from questions_table where dbS_No = %d" ,i );
                
                Statement sm = conn.createStatement();
                ResultSet rs = sm.executeQuery( query1 );
                while( rs.next() )
                {  
                     dbans = rs.getString("dbans").trim();
                      String dbsno = rs.getString("dbS_No");
                    String dbquestion = rs.getString("dbquestion");
                    String dbchoice1 = rs.getString("dbchoice1");
                    String dbchoice2 = rs.getString("dbchoice2");
                    String dbchoice3 = rs.getString("dbchoice3");
                    String dbchoice4 = rs.getString("dbchoice4");
                 
                    
                    if(dbchoice1.equals(dbans))
                   {
                    jbans2.setEnabled(false); 
                    jbans3.setEnabled(false);
                   }
                    else if(dbchoice2.equals(dbans))
                   {
                    jbans1.setEnabled(false);
                    jbans3.setEnabled(false);
                   }
                     else if(dbchoice3.equals(dbans))
                   {
                    jbans1.setEnabled(false); 
                    jbans2.setEnabled(false);
                   }
                     else if(dbchoice4.equals(dbans))
                   {
                    jbans1.setEnabled(false);
                    jbans2.setEnabled(false);
                   }
                }    
                jbfifty.setEnabled(false);
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
        
    }//GEN-LAST:event_jbfiftyActionPerformed

    private void jbaudiencepollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbaudiencepollActionPerformed
        // TODO add your handling code here:
         try
         {
                vaudiencepoll = 0;
                String dbans = "";             
                Connection conn = connectdb.getConnection();
                String query1 = String.format( "select * from questions_table where dbS_No = %d" ,i );
                
                Statement sm = conn.createStatement();
                ResultSet rs = sm.executeQuery( query1 );
                while( rs.next() )
                {  
                     dbans = rs.getString("dbans").trim();
                      String dbsno = rs.getString("dbS_No");
                    String dbquestion = rs.getString("dbquestion");
                    String dbchoice1 = rs.getString("dbchoice1");
                    String dbchoice2 = rs.getString("dbchoice2");
                    String dbchoice3 = rs.getString("dbchoice3");
                    String dbchoice4 = rs.getString("dbchoice4");
                 
                    
                    if(dbchoice1.equals(dbans))
                   {
                    pollA aobj = new pollA();
                    aobj.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
                    editing(i);
                    aobj.setVisible(true);
                   }
                    else if(dbchoice2.equals(dbans))
                   {
                    pollB bobj = new pollB();
                    bobj.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
                    editing(i);
                    bobj.setVisible(true);
                   }
                     else if(dbchoice3.equals(dbans))
                   {
                    pollC cobj = new pollC();
                    cobj.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
                    editing(i);
                    cobj.setVisible(true);
                   }
                     else if(dbchoice4.equals(dbans))
                   {
                    pollD dobj = new pollD();
                    dobj.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
                    editing(i);
                    dobj.setVisible(true);
                   }
                }              
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }//GEN-LAST:event_jbaudiencepollActionPerformed

    private void jbskipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbskipActionPerformed
        // TODO add your handling code here:
        vskipquestion = 0;
        i++;
        editing( i );
    }//GEN-LAST:event_jbskipActionPerformed

    private void jbredeemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbredeemActionPerformed
        // TODO add your handling code here:
                 
        String[] lifelines = {"50-50", "Audience Poll", "skip question"};
        
        int choice = JOptionPane.showOptionDialog(rootPane, "Which Lifeline to redeem ?", "Message", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, lifelines, "NORMAL");
        System.out.println("choice = "+choice);
        
        if( choice == 0 )
        {
            if( vfifty == 1 )
            {
                JOptionPane.showMessageDialog(rootPane, "Its already active !!!");
            }
            else
            {
                vredeem = 0;
                JOptionPane.showMessageDialog(rootPane, "50-50 is now available !!!");
                vfifty = 1;
                editing( i );
            }
        }
        if( choice == 1 )
        {
            if( vaudiencepoll == 1 )
            {
                JOptionPane.showMessageDialog(rootPane, "Its already active !!!");
            }
            else
            {  
                vredeem = 0;
                JOptionPane.showMessageDialog(rootPane, "Audience Poll is now available !!!");
                vaudiencepoll = 1;
                editing( i );
            }
        }
        if( choice == 2 )
        {
            if( vskipquestion == 1 )
            {
                JOptionPane.showMessageDialog(rootPane, "Its already active !!!");
            }
            else
            {
                vredeem = 0;
                JOptionPane.showMessageDialog(rootPane, "Skip Question is now available !!!");
                vskipquestion = 1;
                editing( i );
            }
        }
    }//GEN-LAST:event_jbredeemActionPerformed

    private void jbans2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbans2ActionPerformed
        // TODO add your handling code here:
        try
         {
             
                String dbans = "";             
                Connection conn = connectdb.getConnection();
                String query1 = String.format( "select * from questions_table where dbS_No = %d" ,i );
                
                Statement sm = conn.createStatement();
                ResultSet rs = sm.executeQuery( query1 );
                while( rs.next() )
                {  
                    dbans = rs.getString("dbans").trim();
                    String dbsno = rs.getString("dbS_No");
                    String dbquestion = rs.getString("dbquestion");
                     dbchoice1 = rs.getString("dbchoice1");
                     dbchoice2 = rs.getString("dbchoice2");
                     dbchoice3 = rs.getString("dbchoice3");
                     dbchoice4 = rs.getString("dbchoice4");
                }

                if(evt.getActionCommand().equals(dbans))
                {
                    
                    
                    if( money == 0 )
                    {    
                    money = 50000;
                    }
                     else if(money>=6400000)
                    {
                        
                        money = 10000000;
                        writing_scores();
                       JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money+ "\nYou are a Crorepati now !!!");
                       money = 0;
                       jbans1.setEnabled(true);
                       jbans2.setEnabled(true);
                       jbans3.setEnabled(true);
                       jbans4.setEnabled(true);
                       i = 1;
                       vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                       mainclass mainobj = new mainclass();
                       this.setVisible( false );
                       mainobj.setVisible( true );
                       
                       
                    }
                    else{ money = money*2; }
                    
                    if( money!=0 )
                    {
                    JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money);
                    }
                    jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    i++;
                    editing( i );
                }
                
                else
                {   
                   i=1;
                   vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                  JOptionPane.showMessageDialog(rootPane, "wrong ans\ntotal amount " +money);
                  jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    writing_scores();
                    money = 0;
                  mainclass mainobj = new mainclass();
                  this.setVisible(false);
                  mainobj.setVisible(true);
                }
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }//GEN-LAST:event_jbans2ActionPerformed

    private void jbans1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans1MouseExited
        // TODO add your handling code here:
        jbans1.setForeground(Color.BLACK);
        jbans1.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jbans1MouseExited

    private void jbans2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans2MouseExited
        // TODO add your handling code here:
        jbans2.setForeground(Color.BLACK);
        jbans2.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jbans2MouseExited

    private void jbans3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans3MouseExited
        // TODO add your handling code here:
        jbans3.setForeground(Color.BLACK);
        jbans3.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jbans3MouseExited

    private void jbans4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans4MouseExited
        // TODO add your handling code here:
        jbans4.setForeground(Color.BLACK);
        jbans4.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jbans4MouseExited

    private void jbans1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans1MouseEntered
        // TODO add your handling code here:
        jbans1.setForeground(Color.WHITE);
        jbans1.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_jbans1MouseEntered

    private void jbans4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbans4MouseClicked

    private void jbans4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans4MousePressed
        // TODO add your handling code here:
        if( dbchoice4.equals(dbans) )
        {
            
            jbans4.setForeground(Color.WHITE);
            jbans4.setBackground(new Color(0,102,0)); 
           
            

        }
        else
        {
           jbans4.setForeground(Color.WHITE);
            jbans4.setBackground(new Color(153,0,0));
            
        }
    }//GEN-LAST:event_jbans4MousePressed

    private void jbans2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans2MouseEntered
        // TODO add your handling code here:
        jbans2.setForeground(Color.WHITE);
        jbans2.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_jbans2MouseEntered

    private void jbans3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans3MouseEntered
        // TODO add your handling code here:
        jbans3.setForeground(Color.WHITE);
        jbans3.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_jbans3MouseEntered

    private void jbans4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans4MouseEntered
        // TODO add your handling code here:
        jbans4.setForeground(Color.WHITE);
        jbans4.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_jbans4MouseEntered

    private void jbquitplayingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbquitplayingMouseEntered
        // TODO add your handling code here:
        jbquitplaying.setBackground(new Color(153,0,0));
        jbquitplaying.setForeground(Color.WHITE);
    }//GEN-LAST:event_jbquitplayingMouseEntered

    private void jbquitplayingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbquitplayingMouseExited
        // TODO add your handling code here:
        jbquitplaying.setForeground(Color.BLACK);
        jbquitplaying.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jbquitplayingMouseExited

    private void jbfiftyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbfiftyMouseEntered
        // TODO add your handling code here:
        lifelineentered( jbfifty );
    }//GEN-LAST:event_jbfiftyMouseEntered

    private void jbaudiencepollMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbaudiencepollMouseEntered
        // TODO add your handling code here:
        lifelineentered( jbaudiencepoll );
    }//GEN-LAST:event_jbaudiencepollMouseEntered

    private void jbskipMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbskipMouseEntered
        // TODO add your handling code here:
        lifelineentered( jbskip );
    }//GEN-LAST:event_jbskipMouseEntered

    private void jbredeemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbredeemMouseEntered
        // TODO add your handling code here:
        lifelineentered( jbredeem );
    }//GEN-LAST:event_jbredeemMouseEntered

    private void jbfiftyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbfiftyMouseExited
        // TODO add your handling code here:
        lifelineexited( jbfifty );
    }//GEN-LAST:event_jbfiftyMouseExited

    private void jbaudiencepollMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbaudiencepollMouseExited
        // TODO add your handling code here:
        lifelineexited( jbaudiencepoll );
    }//GEN-LAST:event_jbaudiencepollMouseExited

    private void jbskipMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbskipMouseExited
        // TODO add your handling code here:
        lifelineexited( jbskip );
    }//GEN-LAST:event_jbskipMouseExited

    private void jbredeemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbredeemMouseExited
        // TODO add your handling code here:
        lifelineexited( jbredeem );
    }//GEN-LAST:event_jbredeemMouseExited

    private void jbans3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbans3ActionPerformed
        // TODO add your handling code here:
        try
         {
             
                String dbans = "";             
                Connection conn = connectdb.getConnection();
                String query1 = String.format( "select * from questions_table where dbS_No = %d" ,i );
                
                Statement sm = conn.createStatement();
                ResultSet rs = sm.executeQuery( query1 );
                while( rs.next() )
                {  
                    dbans = rs.getString("dbans").trim();
                    String dbsno = rs.getString("dbS_No");
                    String dbquestion = rs.getString("dbquestion");
                     dbchoice1 = rs.getString("dbchoice1");
                     dbchoice2 = rs.getString("dbchoice2");
                     dbchoice3 = rs.getString("dbchoice3");
                     dbchoice4 = rs.getString("dbchoice4");
                }

                if(evt.getActionCommand().equals(dbans))
                {
                    
                    
                    if( money == 0 )
                    {    
                    money = 50000;
                    }
                     else if(money>=6400000)
                    {
                        
                        money = 10000000;
                        writing_scores();
                       JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money+ "\nYou are a Crorepati now !!!");
                       money = 0;
                       jbans1.setEnabled(true);
                       jbans2.setEnabled(true);
                       jbans3.setEnabled(true);
                       jbans4.setEnabled(true);
                       i = 1;
                       vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                       mainclass mainobj = new mainclass();
                       this.setVisible( false );
                       mainobj.setVisible( true );
                    }
                    else{ money = money*2; }
                    
                    if( money!=0 )
                    {
                    JOptionPane.showMessageDialog(rootPane, "right ans !!!\nyou win " +money);
                    }
                    jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    i++;
                    editing( i );
                }
                
                else
                {   
                   i=1;
                   vfifty =1; vaudiencepoll=1; vskipquestion=1; vredeem=1;
                  JOptionPane.showMessageDialog(rootPane, "wrong ans\ntotal amount " +money);
                  jbans1.setEnabled(true);
                    jbans2.setEnabled(true);
                    jbans3.setEnabled(true);
                    jbans4.setEnabled(true);
                    writing_scores();
                    money = 0;
                  mainclass mainobj = new mainclass();
                  this.setVisible(false);
                  mainobj.setVisible(true);
                }
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }//GEN-LAST:event_jbans3ActionPerformed

    private void jbans1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans1MousePressed
        // TODO add your handling code here:
        if( dbchoice1.equals(dbans) )
        {
            
            jbans1.setForeground(Color.WHITE);
            jbans1.setBackground(new Color(0,102,0)); 
           
            

        }
        else
        {
           jbans1.setForeground(Color.WHITE);
            jbans1.setBackground(new Color(153,0,0));
            
        }
    }//GEN-LAST:event_jbans1MousePressed

    private void jbans2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans2MousePressed
        // TODO add your handling code here:
        if( dbchoice2.equals(dbans) )
        {
            
            jbans2.setForeground(Color.WHITE);
            jbans2.setBackground(new Color(0,102,0)); 
           
            

        }
        else
        {
           jbans2.setForeground(Color.WHITE);
            jbans2.setBackground(new Color(153,0,0));
            
        }
    }//GEN-LAST:event_jbans2MousePressed

    private void jbans3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbans3MousePressed
        // TODO add your handling code here:
        if( dbchoice3.equals(dbans) )
        {
            
            jbans3.setForeground(Color.WHITE);
            jbans3.setBackground(new Color(0,102,0)); 
           
            

        }
        else
        {
           jbans3.setForeground(Color.WHITE);
            jbans3.setBackground(new Color(153,0,0));
            
        }
    }//GEN-LAST:event_jbans3MousePressed

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
            java.util.logging.Logger.getLogger(questionsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(questionsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(questionsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(questionsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new questionsgui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbans1;
    private javax.swing.JButton jbans2;
    private javax.swing.JButton jbans3;
    private javax.swing.JButton jbans4;
    private javax.swing.JButton jbaudiencepoll;
    private javax.swing.JButton jbfifty;
    private javax.swing.JButton jbquitplaying;
    private javax.swing.JButton jbredeem;
    private javax.swing.JButton jbskip;
    private javax.swing.JLabel jlquestion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
