/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3.Windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import labb3.ChatDAOImp;
import labb3.DataStructures.Friend;
import labb3.LogReader;
import labb3.ChatDAO;
/**
 *
 * @author André
 */
public class MainWindow {
    private JFrame f;  
    private ChatDAO chatDao = new ChatDAOImp();
    private TopWindow top = new TopWindow();
    private ChatWindow chat = new ChatWindow();
    private FriendWindow friends = new FriendWindow();
    boolean privateMode = false;
    private JCheckBox publicButton = top.getPublicButton();
    private JCheckBox privateButton = top.getPrivateButton();
    public MainWindow(){
        f=new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(top.getWindow(), BorderLayout.NORTH);
        //Set bounds for panel with exit and chat buttons
        top.getShowPanel().setBounds(111,45,110,70);
        top.getExitPanel().setBounds(6,45,100,40);
        //----------------------------------------
        f.add(top.getShowPanel());
        f.add(top.getExitPanel());
        //----------------------------------------
        populateFriendlist();
        addClickListiner();
        addPublicClick();
        addPrivateClick();
        addSendChatClick();
        //----------------------------------------
        JPanel bottom = new JPanel();
        bottom.add(chat.getWindow(), BorderLayout.WEST);
        bottom.add(friends.getWindow(), BorderLayout.EAST);
        //-----------------------------------------
        Border blackline = BorderFactory.createLineBorder(Color.black);
        bottom.setBorder(blackline);
        f.add(bottom);
        f.pack();
        f.setVisible(true); 
        f.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                chat.getWindow().setPreferredSize(new Dimension(f.getWidth()-chatDao.getLongestNick()-50, f.getHeight()-80));
                //chat.getChatText().setPreferredSize(new Dimension(f.getWidth()-chatDao.getLongestNick()-50, f.getHeight()));
                friends.getWindow().setPreferredSize(new Dimension(chatDao.getLongestNick()+10,f.getHeight()-80));
                f.repaint();
                //System.out.println(f.getHeight() + " "+f.getWidth()+ " "+chat.getWindow().getWidth());
            }
        });
    }
    private void addSendChatClick(){
        chat.getMessageButton().addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent me) { 
                if(me.getButton() == 1){
                    System.out.println(chat.getMessageInput().getText());
                    chatDao.sendMessage(chat.getMessageInput().getText());
                    loadPrivateChat();
                }
            } 
        });
    }
    private void populateFriendlist(){
        for(int i = 0; i < chatDao.getAllFriends().size(); i++){
            Friend currentFriend = chatDao.getAllFriends().get(i);
            String currentName = currentFriend.getNick()+currentFriend.getTag();
            JLabel nameLabel = new JLabel(currentName);
            nameLabel.setName(currentName);
            friends.getNamePanel().add(nameLabel, BorderLayout.WEST);
        }
    }
    private void addClickListiner(){
        for(int i = 0; i < friends.getNamePanel().getComponentCount(); i++){
            friends.getNamePanel().getComponent(i).addMouseListener(new MouseAdapter() { 
                public void mousePressed(MouseEvent me) { 
                    if(me.getButton() == 3){
                        System.out.println("Ändra");
                    }
                    else if(privateMode == true && me.getButton() == 1){
                        chatDao.setReciever(me.getComponent().getName());
                        chatDao.setPrivateChat(me.getComponent().getName());
                    }
                } 
            });
        }
    }
    private void loadPrivateChat(){
        List<String> history = chatDao.getPrivateChat(chatDao.getReceiever());
        chat.getChatText().setText("");
        chat.getChatLabel().setText("Chatting with "+chatDao.getReceiever());
        chatDao.setReciever(chatDao.getReceiever());
        for(int i = 0; i < history.size(); i++){
            chat.getChatText().append(history.get(i));
        }
    }
    private void addPublicClick(){
        publicButton.addActionListener((ActionEvent e) -> {
            chat.getChatText().setText(""); 
            chat.getChatLabel().setText("Not chatting");
            if(publicButton.isSelected()){
                chat.getChatLabel().setText("Chatting publicly");
                List<String> messages = chatDao.getPublicChat();
                for(int i = 0; i < messages.size(); i++){
                    chat.getChatText().append(messages.get(i));
                }
            }
            privateButton.setSelected(false);
            privateMode = false;
            top.getShowPanel().setVisible(false);
            top.getExitPanel().setVisible(false);
        });
    }
    private void addPrivateClick(){
        privateButton.addActionListener((ActionEvent e) -> {
            privateMode = !privateMode;
            chat.getChatLabel().setText("Not chatting");
            publicButton.setSelected(false);
            chat.getChatText().setText("");
            top.getShowPanel().setVisible(false);
            top.getExitPanel().setVisible(false);
        });
    }
}
