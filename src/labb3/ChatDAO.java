/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3;

import java.util.List;
import labb3.DataStructures.Friend;

/**
 *
 * @author André
 */
public interface ChatDAO {
    public List<Friend> getAllFriends();
    public List<String> getPublicChat();
    public List<String> getPrivateChat(String nick);
    public int getLongestNick();
    public void setChatUser(String newUser);
    public void sendMessage(String msg);
    public void setReciever(String newReciever);
    public void setPrivateMode(boolean newMode);
    public String getReceiever();
    public String getChatUser();
}
