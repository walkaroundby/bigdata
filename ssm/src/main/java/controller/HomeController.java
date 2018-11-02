package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
    @Autowired
    UserService userService;
    /**
     * 访问首页
     * @return
     */
    @RequestMapping("/home")
    public String goHome(){
        System.out.println("hello world");
        return "index";
    }

    @RequestMapping("/register")
    public String goReg(HttpServletRequest req){
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        System.out.println(userName);
        System.out.println(passWord);
        return "index";
    }
}
