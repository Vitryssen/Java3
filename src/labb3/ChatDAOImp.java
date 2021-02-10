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
public class ChatDAOImp implements ChatDAO{
    private String chatUser = "Eurakarte";
    private String chattingWith = "";
    private List<Friend> friends;
    private List<Message> msgs;
    private Chat currentChat;
    public boolean privateMode = false;
    public ChatDAOImp(){
        FriendsReader loadFriends = new FriendsReader();
        friends = loadFriends.getFriendList();
        
        LogReader defaultLog = new LogReader(chatUser);
        msgs = defaultLog.getFormatted();
    }
    @Override
    public List<Friend> getAllFriends(){
        return friends;
    }
    @Override
    public void setPrivateMode(boolean newMode){
        privateMode = newMode;
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
        List<String> returnList = new ArrayList<>();
        msgs = currentChat.getMessages();
        for(int i = 0; i < msgs.size(); i++){
            Friend author = msgs.get(i).getAuthor();
            String newString = "<"+author.getNick()+author.getTag()+"> "+msgs.get(i).getMessage()+"\n";
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
    public void setPrivateChat(String nick) {
        currentChat = new Chat(chatUser);
        msgs = currentChat.getMessages(nick);
    }
    @Override
    public List<String> getPrivateChat(String nick) { 
        List<String> returnList = new ArrayList<>();
        for(int i = 0; i < msgs.size(); i++){
            Friend author = msgs.get(i).getAuthor();
            String newString = "<"+author.getNick()+author.getTag()+"> "+msgs.get(i).getMessage()+"\n";
            returnList.add(newString);
        }
        return returnList;
    }
    @Override
    public void setChatUser(String newUser) {
        this.chatUser = newUser;
    }
    @Override
    public void sendMessage(String msg){
        Friend currentFriend = new Friend();
        currentFriend.setNick(chatUser);
        Message newMsg = new Message(currentFriend, msg);
        new LogWriter(newMsg);
        msgs.add(newMsg);
    }
    @Override
    public void setReciever(String newReciever){
        chattingWith = newReciever;
    }
    @Override
    public String getReceiever(){
        return chattingWith;
    }
}