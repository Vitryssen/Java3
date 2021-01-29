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
public class Chat  implements ActionListener {  
JFrame f;  
int height = 500;
int width = 500;
JPanel showPanel = new JPanel();
JPanel top = new JPanel(new GridBagLayout());
public void actionPerformed(ActionEvent e){  
        if(showPanel.isVisible())
            showPanel.setVisible(false);
        else
            showPanel.setVisible(true);
} 
Chat(){  
    Border blackline;
    blackline = BorderFactory.createLineBorder(Color.black);
    GridBagConstraints c = new GridBagConstraints();
    f=new JFrame();  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel friends = new JPanel();
    friends.setLayout(new BoxLayout(friends, BoxLayout.Y_AXIS));
    friends.setPreferredSize(new Dimension((int) (0.47*width),70));
    friends.setBorder(blackline);
    
    JPanel chat = new JPanel();
    chat.setLayout(new BoxLayout(chat, BoxLayout.Y_AXIS));
    chat.setPreferredSize(new Dimension((int) (0.47*width),70));
    chat.setBorder(blackline);
    
    JButton fileButton = new JButton("File");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 1;
    c.gridx = 0;
    c.gridy = 0;
    c.anchor = GridBagConstraints.NORTHWEST;
    top.add(fileButton , c);
    //fileButton.setPreferredSize(new Dimension(100,40));
    
    JButton showButton = new JButton("Show");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;       //reset to default
    c.weighty = 1.0;   //request any extra vertical space
    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
    c.insets = new Insets(0,0,0,300);  //top padding
    c.gridx = 1;       //aligned with button 2
    c.gridy = 0;       //third row
    showButton.addActionListener(this);
    top.add(showButton, c);
    
    top.addComponentListener(new ComponentAdapter() {
        public void componentResized(ComponentEvent componentEvent) {
            c.insets = new Insets(0,0,0, (int) (0.70*top.getWidth()));  //top padding
            top.add(showButton, c);
            System.out.println(top.getComponentCount());
        }
    });
    
    JButton exitButton = new JButton("Exit");
  
    showPanel = new JPanel();
    showPanel.setBorder(blackline);
    showPanel.setBounds(111,45,110,70);
    //showPanel.setPreferredSize(new Dimension(110,70));
    showPanel.setVisible(false);
    
    JPanel exitPanel = new JPanel();
    exitPanel.setBorder(blackline);
    //exitPanel.setPreferredSize(new Dimension(100,40));
    exitPanel.setBounds(6,45,100,40);
    exitPanel.add(exitButton, BorderLayout.WEST);
    exitButton.setPreferredSize(new Dimension(90,30));
    exitPanel.setVisible(false);
    
    JCheckBox privateButton = new JCheckBox("Private chat");
    JCheckBox publicButton = new JCheckBox("Public chat");
    
// add to a container
    showPanel.add(privateButton, BorderLayout.NORTH);
    showPanel.add(publicButton, BorderLayout.SOUTH);
    privateButton.setPreferredSize(new Dimension(100,20));
    publicButton.setPreferredSize(new Dimension(100,21));

    privateButton.addActionListener((ActionEvent e) -> {
        if(publicButton.isSelected())
            publicButton.setSelected(false);
    });
    publicButton.addActionListener((ActionEvent e) -> {
        if(privateButton.isSelected())
            privateButton.setSelected(false);
    });
    fileButton.addActionListener((ActionEvent e) -> {
        if(exitPanel.isVisible())
            exitPanel.setVisible(false);
        else
            exitPanel.setVisible(true);
    });
    
    exitButton.addActionListener((ActionEvent e) -> {
        System.exit(0);
    });
    
    
    
    //--------------------------Chat------------------------------------
    JTextArea textarea = new JTextArea("test\ntest2");
    textarea.setLineWrap(true);
    textarea.setWrapStyleWord(true);
    chat.add(textarea, c);
    
    //--------------------------Chat------------------------------------
    //--------------------------List------------------------------------
    
    
    
    //--------------------------List------------------------------------
    f.add(top, BorderLayout.NORTH);
    f.add(showPanel);
    f.add(exitPanel);
    JPanel bottom = new JPanel(new GridLayout(0,2));
    bottom.setBorder(blackline);
    bottom.add(friends, BoxLayout.X_AXIS);
    bottom.add(chat, BoxLayout.X_AXIS);
    friends.setMaximumSize(new Dimension(500,500));
    f.add(bottom, BorderLayout.CENTER);
    //top.getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    f.pack();
    f.setVisible(true);   
    
}  
public static void main(String[] args) {  
    Chat test = new Chat();  
}  

} 