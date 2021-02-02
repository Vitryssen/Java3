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
public class ChatWindow extends JPanel{
    public void ChatWindow(){
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //chat.setBorder(blackline);

        JTextArea chatText = new JTextArea("test\ntest2");
        chatText.setLineWrap(true);
        chatText.setWrapStyleWord(true);
        chatText.setBorder(blackline);
        chatText.setEditable(false);

        JLabel chatLabel = new JLabel("Chat with");
        chatLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(chatLabel);
        add(chatText);
        setPreferredSize(new Dimension(150, 140));
    }
    public JPanel getWindow(){
        return this;
    }
}
