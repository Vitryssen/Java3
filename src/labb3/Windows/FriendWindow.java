/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3.Windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import labb3.FriendsReader;

/**
 *
 * @author André
 */
public class FriendWindow extends JPanel {
    private FriendsReader friendList = new FriendsReader();
    private JPanel friends = new JPanel();
    private JPanel namePanel = new JPanel();
    public FriendWindow(){
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);
        friends.setLayout(new BoxLayout(friends, BoxLayout.Y_AXIS));
        
        namePanel.setBorder(blackline);
        namePanel.setBackground(Color.white);
        JLabel friendText = new JLabel("Friends list");
        friendText.setAlignmentX(CENTER_ALIGNMENT);
        
        friends.add(friendText);
        friends.add(namePanel);
        friends.setPreferredSize(new Dimension(longestName()+10, 140)); //width determined by the longest name
    }
    public int longestName(){
        //--------------------------Chat------------------------------------
        int previous = 0;
        for(int i = 0; i < friendList.getFriendList().size(); i++){
            //System.out.println(friendList.getFriendList().get(i).getNick());
            String text = friendList.getFriendList().get(i).getNick();
            AffineTransform affinetransform = new AffineTransform();     
            FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
            Font font = new Font("Tahoma", Font.PLAIN, 12);
            if( ((int)(font.getStringBounds(text, frc).getWidth())+5) > previous)
                previous = (int)(font.getStringBounds(text, frc).getWidth())+5;
        }
        return previous;
    }
    public JPanel getWindow(){
        return friends;
    }
    public FriendsReader getFriendList(){
        return friendList;
    }
    public JPanel getNamePanel(){
        return namePanel;
    }
}
