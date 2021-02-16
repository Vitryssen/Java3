/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3.Readers;

import labb3.DataStructures.Friend;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import labb3.Sortbynick;

/**
 *
 * @author André
 */
public class FriendsReader {
    private List<Friend> friends = new ArrayList<Friend>();
    private String workingPath;
    public FriendsReader(){
        try
        {  
            this.workingPath = System.getProperty("user.dir");
            File file=new File(this.workingPath+"\\logs\\friends.list");    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line; 
            while((line=br.readLine())!=null)  {
                Friend currentFriend = new Friend();
                if(line.indexOf('>') != -1){
                    currentFriend.setNick(line.substring(1,line.indexOf('>')));
                    if(line.indexOf(']') != -1){
                        currentFriend.setNick(line.substring(1,line.indexOf('[')));
                        currentFriend.setTag(line.substring(line.indexOf('['),line.indexOf(']')+1));
                    }
                }
                if((line=br.readLine()) != null)
                    currentFriend.setName(line.substring(line.indexOf(']')+1));
                if((line=br.readLine()) != null)
                    currentFriend.setIp(line.substring(line.indexOf(']')+1));
                if((line=br.readLine()) != null)
                    currentFriend.setImage(line.substring(line.indexOf(']')+1));
                friends.add(currentFriend);
            }
            Collections.sort(friends, new Sortbynick());
            fr.close();
            br.close();
        }
        catch (FileNotFoundException ex) 
        {
            System.out.println("Not found");
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
    }
    public List<Friend> getFriendList(){
        return friends;
    }
    public void saveFriendList(List<Friend> friends){
        File file=new File(this.workingPath+"\\logs\\friends.list");
        try {
            if (file.createNewFile()){
                System.out.println("File is created!");
            }
            else{
                System.out.println("File already exists.");
            }
            FileWriter fr = new FileWriter(file, false);
            
            for(int i = 0; i < friends.size(); i++){
                fr.write("<"+friends.get(i).getNick()+friends.get(i).getTag()+">\n");
                fr.write("[FULLNAME]"+friends.get(i).getName()+"\n");
                fr.write("[LASTIP]"+friends.get(i).getIp()+"\n");
                fr.write("[IMAGE]"+friends.get(i).getImage()+"\n");
            }
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
