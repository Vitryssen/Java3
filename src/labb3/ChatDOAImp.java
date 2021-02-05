/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import labb3.DataStructures.Chat;
import labb3.DataStructures.Friend;
import labb3.DataStructures.Message;

/**
 *
 * @author André
 */
public class ChatDOAImp implements ChatDOA{
    private String chatUser = "Eurakarte";
    private List<Friend> friends;
    private List<Message> msgs;
    private List<Friend> allFriends;
    private Chat currentChat;
    public ChatDOAImp(){
        FriendsReader loadFriends = new FriendsReader();
        friends = loadFriends.getFriendList();
        
        LogReader defaultLog = new LogReader(chatUser);
        msgs = defaultLog.getFormatted();
    }
    @Override
    public List<Friend> getAllFriends(){
        return allFriends;
    }
    @Override
    public int getLongestNick(){
        int previous = 0;
        for(int i = 0; i < friends.size(); i++){
            //System.out.println(friendList.getFriendList().get(i).getNick());
            String text = friends.get(i).getNick();
            AffineTransform affinetransform = new AffineTransform();     
            FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
            Font font = new Font("Tahoma", Font.PLAIN, 12);
            if( ((int)(font.getStringBounds(text, frc).getWidth())+5) > previous)
                previous = (int)(font.getStringBounds(text, frc).getWidth())+5;
        }
        return previous;
    }

    @Override
    public List<String> getPublicChat() {
        currentChat = new Chat(chatUser);
        List<String> returnList = new ArrayList<String>();
        List<Message> oldList = currentChat.getMessages();
        for(int i = 0; i < oldList.size(); i++){
            Friend author = oldList.get(i).getAuthor();
            String newString = "<"+author.getNick()+author.getTag()+"> "+oldList.get(i).getMessage()+"\n";
            returnList.add(newString);
        }
        return returnList;
    }

    @Override
    public Friend getFriend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chat getChat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getPrivateChat(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChatUser(String newUser) {
        this.chatUser = newUser;
    }
}
