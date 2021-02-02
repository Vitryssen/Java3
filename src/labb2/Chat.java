/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb2;

import java.awt.*; 
import java.awt.event.*; 
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.swing.*; 
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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
    JPanel chat = new JPanel();
    chat.setLayout(new BoxLayout(chat, BoxLayout.Y_AXIS));
    //chat.setBorder(blackline);
    
    JTextArea chatText = new JTextArea("test\ntest2");
    chatText.setLineWrap(true);
    chatText.setWrapStyleWord(true);
    chatText.setBorder(blackline);
    chatText.setEditable(false);
    
    JLabel chatLabel = new JLabel("Chat with <>");
    chatLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
   
    chat.add(chatLabel);
    chat.add(chatText);
    //--------------------------Chat------------------------------------
    //--------------------------List------------------------------------
    
    JPanel friends = new JPanel();
    friends.setLayout(new BoxLayout(friends, BoxLayout.Y_AXIS));
    
    JTextArea friendArea = new JTextArea("Donut[AFK]\nMiles_Prower");
    //friendArea.setBorder(blackline);
    
    JLabel friendText = new JLabel("Friends list");
    friendText.setAlignmentX(Component.CENTER_ALIGNMENT);
    friendArea.setEditable(false);
    friendArea.setBorder(blackline);
    
    friends.add(friendText);
    friends.add(friendArea);
    friends.setPreferredSize(new Dimension(50, 75)); //width determined by the longest name
    //--------------------------List------------------------------------
    JPanel bottom = new JPanel();
    
    String text = "Miles_Prower"; //Create a loop and use user nicks to compare
                                  //which has the longest name and use that one to set width
    AffineTransform affinetransform = new AffineTransform();     
    FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
    Font font = new Font("Tahoma", Font.PLAIN, 12);
    int textwidth = (int)(font.getStringBounds(text, frc).getWidth())+5;
    
    bottom.add(chat, BorderLayout.WEST);
    chat.setPreferredSize(new Dimension(150, 140));
    f.addComponentListener(new ComponentAdapter() {
        public void componentResized(ComponentEvent componentEvent) {
            chat.setPreferredSize(new Dimension(f.getWidth()-textwidth-50, f.getHeight()-70));
            friends.setPreferredSize(new Dimension(textwidth,f.getHeight()-70));
            friends.revalidate();
            System.out.println(f.getHeight() + " "+f.getWidth());
        }
    });
    bottom.add(friends, BorderLayout.EAST);
    //------------------------Bottom------------------------------------
    f.add(top, BorderLayout.NORTH);
    f.add(showPanel);
    f.add(exitPanel);
    f.add(bottom, BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);   
    
}  
public static void main(String[] args) {  
    Chat test = new Chat();  
}  

} 