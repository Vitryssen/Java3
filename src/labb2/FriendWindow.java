/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author André
 */
public class FriendWindow extends JPanel {
    public JPanel friends = new JPanel();
    public void FriendWindow(){
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);
        friends.setLayout(new BoxLayout(friends, BoxLayout.Y_AXIS));

        JTextArea friendArea = new JTextArea("Donut[AFK]\nMiles_Prower");
        //friendArea.setBorder(blackline);

        JLabel friendText = new JLabel("Friends list");
        friendText.setAlignmentX(Component.CENTER_ALIGNMENT);
        friendArea.setEditable(false);
        friendArea.setBorder(blackline);

        friends.add(friendText);
        friends.add(friendArea);
        friends.setPreferredSize(new Dimension(longestName(), 140)); //width determined by the longest name
    }
    public int longestName(){
        //--------------------------Chat------------------------------------
        String text = "Miles_Prower"; //Create a loop and use user nicks to compare
                                     //which has the longest name and use that one to set width
       AffineTransform affinetransform = new AffineTransform();     
       FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
       Font font = new Font("Tahoma", Font.PLAIN, 12);
       int textwidth;
       return textwidth = (int)(font.getStringBounds(text, frc).getWidth())+5;
    }
    public JPanel getWindow(){
        return friends;
    }
}
