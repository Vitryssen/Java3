/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.*; 
import java.awt.event.*; 
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author André
 */
public class Chat{  
    public static void main(String[] args) {  
        JFrame f=new JFrame();  
        TopWindow top = new TopWindow();
        ChatWindow chat = new ChatWindow();
        FriendWindow friends = new FriendWindow();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(top.getWindow(), BorderLayout.NORTH);
        f.add(top.getShowPanel());
        f.add(top.getExitPanel());
        //----------------------------------------
        JPanel bottom = new JPanel();
        bottom.add(new ChatWindow(), BorderLayout.WEST);
        bottom.add(friends.getWindow(), BorderLayout.EAST);
        //-----------------------------------------
        f.add(bottom, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true); 
    }  
} 