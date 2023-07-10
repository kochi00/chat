package jp.ac.shibaura_it.infolab1.chat;

import java.util.Scanner;

public class ChannelOperation {
    public void Show(Channels list){
        int channelNumber=1;
        for (Channel channel : list.channelList) {
            System.out.println(channelNumber+". "+channel.name+" : "+channel.description);
            channelNumber++;
        }
    }
    public Channel Select(int channelNumber, Channels list){
        //存在しないチャンネルを入力した場合エラーを表示
        if (channelNumber>list.channelList.size()){
            System.out.println("Channel does not exist");
            return null;
        }
        Channel channel = list.channelList.get(channelNumber-1);
        System.out.println("You are in "+list.channelList.get(channelNumber-1).name);
        return channel;
    }
    public void Chat(Channel channel, String username) {
        for (String chatList : channel.chatList) {
            System.out.println(chatList);
        }
        String chat = null;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            chat = scanner.nextLine();
            if (chat.equals("exit")) {
                break;
            }
            channel.addChat(username+": "+chat);
        }

    }
}
