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
    //top.add( Box.createHorizontalGlue() );
    top.add(button);
    button.setPreferredSize(new Dimension(100,40));
    //top.add( Box.createHorizontalStrut(0) );
    //Show
    JButton show = new JButton("Show");
    show.setBorder(blackline);
    show.setPreferredSize(new Dimension(110,40));
    top.add(show);
    //top.add( Box.createHorizontalGlue() ); 
    
    JPanel testing = new JPanel();
    testing.setBorder(blackline);
    //testing.setPreferredSize(new Dimension(110,40));
    testing.setBounds(111,45,110,70);
    testing.setVisible(false);
    
    JPanel testing2 = new JPanel();
    testing2.setBorder(blackline);
    //testing.setPreferredSize(new Dimension(110,40));
    testing2.setBounds(6,45,100,40);
    //testing.setVisible(false);
    
    JCheckBox checkbox1 = new JCheckBox("Private chat");
    JCheckBox checkbox2 = new JCheckBox("Public chat");
 
    JButton checkbox3 = new JButton("Exit");
    testing2.add(checkbox3, BorderLayout.WEST);
    checkbox3.setPreferredSize(new Dimension(90,30));
    testing2.setVisible(false);
    button.addActionListener((ActionEvent e) -> {
        if(testing2.isVisible())
            testing2.setVisible(false);
        else
            testing2.setVisible(true);
    });
    
    checkbox3.addActionListener((ActionEvent e) -> {
        System.exit(0);
    });
    
// add to a container
    testing.add(checkbox1, BorderLayout.NORTH);
    testing.add(checkbox2, BorderLayout.SOUTH);
    checkbox1.setPreferredSize(new Dimension(100,20));
    checkbox2.setPreferredSize(new Dimension(100,21));

    show.addActionListener((ActionEvent e) -> {
        if(testing.isVisible())
            testing.setVisible(false);
        else
            testing.setVisible(true);
    });
    checkbox1.addActionListener((ActionEvent e) -> {
        if(checkbox2.isSelected())
            checkbox2.setSelected(false);
    });
    checkbox2.addActionListener((ActionEvent e) -> {
        if(checkbox1.isSelected())
            checkbox1.setSelected(false);
    });
    
    f.add(testing);
    f.add(testing2);
    JPanel bottom = new JPanel();
    bottom.setBorder(blackline);
    
    f.add(top, BorderLayout.NORTH);
    //top.setPreferredSize(new Dimension(100,50));
    f.add(bottom, BorderLayout.CENTER);
    //bottom.setPreferredSize(new Dimension(100,100));
    f.pack();
    f.setSize(500,500);
    f.setVisible(true);   
}  
public static void main(String[] args) {  
    new Chat();  
}  
} 