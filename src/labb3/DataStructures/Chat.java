/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3.DataStructures;

import java.util.List;
import labb3.LogReader;
import labb3.LogWriter;

/**
 *
 * @author André
 */
public class Chat {
    private String author;
    public Chat(String nickname){
      this.author = nickname;
    }
    public void addMessage(Message msg){
        new LogWriter(author, msg.getMessage());
    }
    public List<Message> getMessages(){
        LogReader reader = new LogReader(author);
        return reader.getFormatted();
    }
}
