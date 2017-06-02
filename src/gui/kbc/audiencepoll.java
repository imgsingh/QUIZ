/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.kbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.*;

/**
 *
 * @author S A N D H U
 */
public class audiencepoll extends JApplet 
{
    private JLabel jlitem; 
    
    public void paint( Graphics g )
    {
        g.drawLine(20, 30, 20, 230);
        g.setColor( Color.green ); 
        g.fill3DRect(100, 150, 100, 150, false);

    }
    

    
 
}
