package jp.ac.shibaura_it.infolab1.chat;

public class Login {
    String loginName;
    public int login(String username, String password, Users userList) {
        //返り値　１：ログイン成功　０：ログイン失敗
        while (true){
            for (User user : userList.userList) {
                if (user.username.equals(username) && user.password.equals(password)) {
                    System.out.println("Login success");
                    loginName=username;
                    return 1;
                }
                if (user.username.equals(username)) {
                    System.out.println("Wrong password");
                    break;
                }
                if (userList.userList.indexOf(user) == userList.userList.size() - 1) {
                    System.out.println("User not found");
                    break;
                }
            }
            System.out.println("Login failed");
            return 0;
        }
        }

}
