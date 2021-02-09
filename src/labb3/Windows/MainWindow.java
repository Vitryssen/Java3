/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3.Windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import labb3.ChatDOA;
import labb3.ChatDOAImp;
import labb3.DataStructures.Friend;
import labb3.LogReader;
/**
 *
 * @author André
 */
public class MainWindow {
    private JFrame f;  
    private ChatDOA chatDao = new ChatDOAImp();
    private TopWindow top = new TopWindow();
    private ChatWindow chat = new ChatWindow();
    private FriendWindow friends = new FriendWindow();
    boolean privateMode = false;
    public MainWindow(){
        f=new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(top.getWindow(), BorderLayout.NORTH);
        //------------------------------------------
        JCheckBox publicButton = top.getPublicButton();
        JCheckBox privateButton = top.getPrivateButton();
        publicButton.addActionListener((ActionEvent e) -> {
            chat.getChatText().setText(""); 
            chat.getChatLabel().setText("Chatting publicly");
            if(privateButton.isSelected()){
                privateButton.setSelected(false);
            }
            if(publicButton.isSelected()){
                List<String> messages = chatDao.getPublicChat();
                for(int i = 0; i < messages.size(); i++){
                    chat.getChatText().append(messages.get(i));
                }
            }
            privateMode = false;
            f.repaint();
        });
        privateButton.addActionListener((ActionEvent e) -> {
            privateMode = !privateMode;
            if(publicButton.isSelected()){
                publicButton.setSelected(false);
            }
            chat.getChatText().setText("");
            f.repaint();
        });
        
        //----------------------------------------
        //Set bounds for panel with exit and chat buttons
        top.getShowPanel().setBounds(111,45,110,70);
        top.getExitPanel().setBounds(6,45,100,40);
        //----------------------------------------
        f.add(top.getShowPanel());
        f.add(top.getExitPanel());
        //----------------------------------------
        populateFriendlist();
        addClickListiner();
        //----------------------------------------
        JPanel bottom = new JPanel();
        bottom.add(chat.getWindow(), BorderLayout.WEST);
        bottom.add(friends.getWindow(), BorderLayout.EAST);
        //-----------------------------------------
        f.add(bottom, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true); 
        f.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                chat.getWindow().setPreferredSize(new Dimension(f.getWidth()-chatDao.getLongestNick()-50, f.getHeight()-80));
                friends.getWindow().setPreferredSize(new Dimension(chatDao.getLongestNick()+10,f.getHeight()-80));
                f.repaint();
                //System.out.println(f.getHeight() + " "+f.getWidth()+ " "+chat.getWindow().getWidth());
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
                    if(privateMode == true){
                        //System.out.println(me.getComponent().getName());
                        LogReader privateChat = new LogReader(me.getComponent().getName());  
                        List<String> history = privateChat.getUnformatted();
                        chat.getChatText().setText("");
                        chat.getChatLabel().setText("Chatting with "+me.getComponent().getName());
                        for(int i = 0; i < history.size(); i++){
                            chat.getChatText().append(history.get(i));
                            chat.getChatText().append("\n");
                        }
                        f.repaint();
                    }
                } 
            });
        }
    }
}
