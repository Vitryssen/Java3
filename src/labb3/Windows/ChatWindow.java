/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3.Windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

/**
 *
 * @author André
 */
public class ChatWindow extends JPanel{
    private final JPanel chat = new JPanel();
    private final JTextArea chatText = new JTextArea("");
    private final JPanel messagePanel = new JPanel();
    private final JLabel chatLabel = new JLabel("Not chatting");
    public ChatWindow(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        chat.setLayout(new BoxLayout(chat, BoxLayout.Y_AXIS));

        chatText.setLineWrap(true);
        chatText.setWrapStyleWord(true);
        chatText.setBorder(blackline);
        chatText.setEditable(false);
        
        JScrollPane scroll = new JScrollPane(chatText);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        chatLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        messagePanel.setBorder(blackline);
        
        chat.add(chatLabel); 
        chat.add(scroll);
        chat.add(messagePanel);
        chat.setPreferredSize(new Dimension(310, 140));
    }
    public JPanel getWindow(){
        return chat;
    }
    public JTextArea getChatText(){
        return chatText;
    }
    public JLabel getChatLabel(){
        return chatLabel;
    }
}
