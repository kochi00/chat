package jp.ac.shibaura_it.infolab1.chat;

import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    ArrayList<User> userList = new ArrayList<User>();
    //返り値が0の場合はエラー
    //返り値が1の場合は成功
    public int addUser(String username,String password) {
        //記号が入力されていた場合エラーを出す
        if (username.contains(" ") || password.contains(" ")) {
            System.out.println("Username and password cannot contain spaces");
            return 0;
        }
        //既にある名前が登録された場合エラー表示
        for (User user : userList) {
            if (user.username.equals(username)) {
                System.out.println("This username is already registered");
                return 0;
            }
        }
        userList.add(new User(username, password));
        return 1;
    }
    public void Show() {
        for (User user : userList) {
            System.out.println(user.username);
        }
    }
}
