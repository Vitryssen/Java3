/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3.Windows;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import labb3.ChatDOA;
import labb3.ChatDOAImp;

/**
 *
 * @author André
 */
public class FriendWindow extends JPanel {
    ChatDOA chatDao = new ChatDOAImp();
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
        friends.setPreferredSize(new Dimension(chatDao.getLongestNick()+10, 140)); //width determined by the longest name
    }
    public JPanel getWindow(){
        return friends;
    }
    public JPanel getNamePanel(){
        return namePanel;
    }
}
