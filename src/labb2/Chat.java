/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.border.Border;

/**
 *
 * @author André
 */
public class Chat {  
JFrame f;  
Chat(){  
    Border blackline;
    blackline = BorderFactory.createLineBorder(Color.black);
    f=new JFrame();  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
    top.setBorder(blackline);
    
    //Top bar with dropdown menu for file and show
    //File contains option "Exit"
    //Show containts checkbox for Private chat and Public chat
    //File
    JButton button = new JButton("File");
    top.add(button);
    button.setPreferredSize(new Dimension(100,40));
    //Show
    JPanel show = new JPanel();
    show.setBorder(blackline);
    show.setPreferredSize(new Dimension(100,40));
    top.add(show);
    
    JPanel testing = new JPanel();
    testing.setBorder(blackline);
    testing.setPreferredSize(new Dimension(100,40));
    testing.setBounds(100,40,100,100);
    f.add(testing);
    JPanel bottom = new JPanel();
    bottom.setBorder(blackline);
    
    f.add(top, BorderLayout.NORTH);
    top.setPreferredSize(new Dimension(100,50));
    f.add(bottom, BorderLayout.CENTER);
    //bottom.setPreferredSize(new Dimension(100,100));
    f.setSize(500,500);
    f.setVisible(true);   
}  
public static void main(String[] args) {  
    new Chat();  
}  
} 