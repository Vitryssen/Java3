/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author André
 */
public class MainWindow {
    JFrame f;  
    public void MainWindow(){
        f=new JFrame();  
        TopWindow top = new TopWindow();
        ChatWindow chat = new ChatWindow();
        FriendWindow friends = new FriendWindow();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(top.getWindow(), BorderLayout.NORTH);
        f.add(top.getShowPanel());
        f.add(top.getExitPanel());
        //----------------------------------------
        JPanel bottom = new JPanel();
        bottom.add(chat.getWindow(), BorderLayout.WEST);
        bottom.add(friends.getWindow(), BorderLayout.EAST);
        //-----------------------------------------
        f.add(bottom, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true); 
        /*f.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                chat.setPreferredSize(new Dimension(f.getWidth()-textwidth-50, f.getHeight()-80));
                friends.setPreferredSize(new Dimension(textwidth,f.getHeight()-80));
                friends.revalidate();
                System.out.println(f.getHeight() + " "+f.getWidth());
            }
        });*/
    }
}
