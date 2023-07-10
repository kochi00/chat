package jp.ac.shibaura_it.infolab1.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

}
/*
package jp.ac.shibaura_it.infolab1.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
@Controller
public class Chat {
    private List<String> chats = new ArrayList(List.of("Kenji: Hello", "Dai: Hello, too!"));
    @RequestMapping(value="/hello")
    String hello(Model model) {
        model.addAttribute("chats", chats);
        return "home.html";
    }
    @RequestMapping(value="/login")
    String addChat(@RequestParam("name") String name,
                   @RequestParam("chat") String chat) {
        chats.add(name + ":" + chat);
        return "redirect:/hello";
    }
}
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
<h1>Hello</h1>
<form action="/add">
    <label>名前</label>
    <input name="name" type="text" />
    <label>チャット</label>
    <input name="chat" type="text" />
    <input type="submit" value="発言" />
</form>
<table>
    <tbody>
    <tr th:each="chat : ${chats}">
        <td th:text="${chat}"></td>
    </tr>
    </tbody>
</table>
</body>
</html>




//アカウント作成画面
<h1>Sign Up</h1>
<form action="/signup" >
    <label>Username</label>
    <input name="username" type="text" />
    <label>Password</label>
    <input name="password" type="text" />
    <input type="submit" value="Sign Up" />
</form>
<table>
    <tbody>
    <tr th:each="inform : ${inform}">
        <td th:text="${inform}"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
 */
