package jp.ac.shibaura_it.infolab1.chat;

import java.util.ArrayList;

public class Channel {
    String name;
    String description;
    ArrayList<String> chatList = new ArrayList<String>();
    public Channel(String name, String description){
        this.name=name;
        this.description=description;
        this.chatList.add("Welcome to "+name);
    }
    public void addChat(String chat) {
        chatList.add(chat);
    }
}
