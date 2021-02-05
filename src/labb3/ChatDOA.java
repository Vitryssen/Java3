/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3;

import java.util.List;
import labb3.DataStructures.Chat;
import labb3.DataStructures.Friend;
import labb3.DataStructures.Message;

/**
 *
 * @author André
 */
public interface ChatDOA {
    public List<Friend> getAllFriends();
    public List<String> getPublicChat();
    public List<String> getPrivateChat(String nick);
    public Friend getFriend();
    public Message getMessage();
    public Chat getChat();
    public int getLongestNick();
    public void setChatUser(String newUser);
}
