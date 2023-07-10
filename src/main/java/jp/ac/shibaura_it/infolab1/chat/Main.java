package jp.ac.shibaura_it.infolab1.chat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Users userList = new Users();
        Channels channelList = new Channels();
        Login login = new Login();
        ChannelOperation channelOperation = new ChannelOperation();
        int loginStatus = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login  2. Register 3. User List 4. Exit");

            String i= scanner.nextLine();
            if (i.equals("1")) {
                System.out.println("Enter username");
                String login_username = scanner.nextLine();
                System.out.println("Enter password");
                String login_password = scanner.nextLine();
                loginStatus=login.login(login_username, login_password, userList);
                //ここからログインできた場合のチャンネルの処理
                if (loginStatus==1){
                    while (true) {
                        System.out.println("1. Add channel 2. Show channel 3. Select channel 4. Exit");
                        String j = scanner.nextLine();
                        if (j.equals("1")) {
                            System.out.println("Enter channel name");
                            String name = scanner.nextLine();
                            System.out.println("Enter channel description");
                            String description = scanner.nextLine();
                            channelList.addChannel(name, description);
                        } else if (j.equals("2")) {
                            channelOperation.Show(channelList);
                        } else if (j.equals("3")) {
                            System.out.println("Enter channel number");
                            int channelNumber = scanner.nextInt();
                            System.out.println("exit to exit");
                            Channel channel = channelOperation.Select(channelNumber, channelList);
                            channelOperation.Chat(channel,login_username);
                        } else if (j.equals("4")) {
                            break;
                        }
                    }
                }
            } else if (i.equals("2")) {
                System.out.println("Enter username");
                String username = scanner.nextLine();
                System.out.println("Enter password");
                String password = scanner.nextLine();
                userList.addUser(username, password);
            } else if (i.equals("3")) {
                userList.Show();
            } else if (i.equals("4")) {
                break;
            }
        }
    }
}
