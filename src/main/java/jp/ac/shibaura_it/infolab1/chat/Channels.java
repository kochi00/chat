package jp.ac.shibaura_it.infolab1.chat;

import java.util.ArrayList;
import java.util.Scanner;

public class Channels {
    ArrayList<Channel> channelList = new ArrayList<Channel>();
    //返り値が0の場合はエラー
    //返り値が1の場合は成功
    public int addChannel(String name, String description) {
        //同じ名前のチャネルが入力された場合エラーを表示
        for (Channel channel : channelList) {
            if (channel.name.equals(name)) {
                System.out.println("This channel is already registered");
                return 0;
            }
        }
        channelList.add(new Channel(name,description));
        return 1;
    }
}
