package jp.ac.shibaura_it.infolab1.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
@Controller
public class Chat {
    private List<String> inform = new ArrayList<>();
    @RequestMapping(value="/hello")
    String hello(Model model) {


        return "home.html";
    }
    int i=0;
    Users users = new Users();

    //アカウント作成
    @RequestMapping(value="/signup1")
    String signup(Model model) {
        model.addAttribute("message1", text1);
        return "signup.html";
    }
    String text1="";
    @RequestMapping(value="/signup2")
    String signup(@RequestParam("name") String name,
                   @RequestParam("password") String password,
                   Model model) {
        i=users.addUser(name, password);
        if (i==1){
            text1=(" [ "+name+" ] "+" sign up success");
        }
        else{
            text1="sign up failed";
        }
        return "redirect:/signup1";
    }

    //ログイン
    @RequestMapping(value="/login1")
    String login(Model model) {
        model.addAttribute("message2", text2);
        return "login.html";
    }
    String text2="";
    @RequestMapping(value="/login2")
    String login(@RequestParam("username") String name,
                 @RequestParam("password") String password,
                 Model model) {
        i=0;
        i=login.login(name, password, users);
        if (i==1){
            text2="login success";
            return "redirect:/channel";
        }
        else{
            text2="login failed";
        }
        return "redirect:/login1";
    }

    Login login = new Login();

    //チャンネル操作
    String login_username;
    @RequestMapping(value="/channel")
    String home(Model model) {
        model.addAttribute("channelList", channelList);
        model.addAttribute("message", text);
        login_username = "Welcome  to   [ "+login.loginName+" ]!!";
        model.addAttribute("login_username", login_username);
        return "channel.html";
    }



    ChannelOperation channelOperation = new ChannelOperation();//チャンネル操作
    Channels channels = new Channels();//チャンネル一覧
    Channel nowChannel ;//現在のチャンネル

    @RequestMapping(value="/select")
    String select(@RequestParam("channel_name") String name,
                  Model model) {
        for(int i=0; i<channels.channelList.size(); i++){
            if (channels.channelList.get(i).name.equals(name)){
                nowChannel = channels.channelList.get(i);
            }
        }

        return "redirect:/chat";
    }

    String text="";
    ArrayList<String> channelList = new ArrayList<>();
    int number =0;
    @RequestMapping(value="/add channel")
    String add(@RequestParam("channel name") String channel,
               @RequestParam("description") String description,
               Model model) {
        i=0;
        i=channels.addChannel(channel, description);
        if (i==1){
            number++;
            text=("create  ["+channel+"]  channel");
            channelList.add(number+". "+channel+" : "+description);
        }
        else{
            text="A channel with the same name already exists";
        }
        return "redirect:/channel";
    }
    //チャット画面に移行したときにチャットの内容を表示する
    String title="";
    String description="";
    @RequestMapping(value="/chat")
    String chat(Model model) {
        title = nowChannel.name+"   Channel";
        model.addAttribute("title", title);
        description = "Description  :  "+nowChannel.description;
        model.addAttribute("description", description);
        model.addAttribute("message", nowChannel.chatList);
        return "Chat.html";
    }
    @RequestMapping(value="/message")
    String chat(@RequestParam("message") String message,
                Model model) {
        nowChannel.chatList.add(login.loginName + ":" + message);
        return "redirect:/chat";
    }



}
    /*
    private List<String> inform = new ArrayList<>();
    int i = 0;//ログインが成功したかどうかを判定する変数
    @RequestMapping(value="/hello")
    String hello(Model model) {
        model.addAttribute("inform", inform);
        return "home.html";
    }

    private Users users = new Users();
    @RequestMapping(value="/login")
    String login(@RequestParam("username") String name,
                   @RequestParam("password") String password) {
        return "redirect:/hello";
    }


    @RequestMapping(value="/signup")
    String signup(@RequestParam("sign_username") String name,
                   @RequestParam("sign_password") String password) {
        inform.add(name+"　は登録に成功しました");
        return "redirect:/hello";*/
        /*
        i=users.addUser(name, password);
        if(i==1){
            inform.add(name+"　は登録に成功しました");
        }else{
            inform.add("登録に失敗しました");
        }
        return "redirect:/hello";
<h1>Login</h1>
<form action="/login" >
    <label>Username</label>
    <input name="username" type="text" />
    <label>Password</label>
    <input name="password" type="password" />
    <input type="submit" value="Login" />
</form>

         */
