/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3;

import labb3.DataStructures.Friend;
import labb3.DataStructures.Message;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author André
 */
public class LogReader {
    private List<Message> lines = new ArrayList<>();
    private List<String> orgLines = new ArrayList<>();
    private String workingPath;
    public LogReader(String fileUrl){
        try
        {  
            workingPath = System.getProperty("user.dir");
            File file=new File(workingPath+"\\logs\\"+fileUrl+".log");    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line; 
            String username;
            while((line=br.readLine())!=null)  {
                String tag = "";
                String text = line.substring(line.indexOf('>')+1);
                if(line.indexOf(']') != -1){
                    username = line.substring(1,line.indexOf('['));
                    tag = line.substring(line.indexOf('['),line.indexOf(']')+1);
                }
                else{
                    username = line.substring(1, line.indexOf('>'));
                }
                
                Friend newFriend = new Friend();
                newFriend.setNick(username);
                newFriend.setTag(tag);
                Message newMsg = new Message(newFriend, text);
                lines.add(newMsg);
                orgLines.add(line);
            }
        }
        catch (FileNotFoundException ex) 
        {
            orgLines.add("Not found");
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
    }
    public List<Message> getFormatted(){
        return lines;
    }
    public List<String> getUnformatted(){
        return orgLines;
    }
}
