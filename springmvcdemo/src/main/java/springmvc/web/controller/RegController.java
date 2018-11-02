package springmvc.web.controller;

import springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Controller
public class RegController {

    @RequestMapping("/toReg")
    public String toRegView(){
        return "reg" ;
    }

    @RequestMapping("/doReg")
    public String doReg(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("插入数据");
        System.out.println(username + "," + password);
        return "index" ;
    }

    @RequestMapping("/doReg2")
    public String doReg(HttpServletRequest req) {
        System.out.println("插入数据222");
        String user = req.getParameter("username");
        System.out.println(user);
        return "index";
    }

    @RequestMapping("/selectOne")
    public String selectOne(Model model , @RequestParam("uid") int uid){
        System.out.println("接受到了参数 : uid = " + uid);
        String username ="tomson" ;
        //将数据存放到model中，向jsp传递.
        model.addAttribute("myusername", username);
        return "selectOne" ;
    }

    @RequestMapping("/selectAll")
    public String selectAll(Model m){
        m.addAttribute("allUsers",DB.findAll());
        return "userList" ;
    }

    @RequestMapping("/deleteOne")
    public String deleteOne(@RequestParam("uid") int uid){
        DB.delete(uid);
        //forware,请求转发,服务器端完成.
        //redirect:重定向.
        return "redirect:/selectAll" ;
    }

    @RequestMapping("/editOne")
    public String editOne(Model m ,@RequestParam("uid") Integer uid){
        User u = DB.select(uid);
        m.addAttribute("user",u);
        return "editUser" ;
    }

    @RequestMapping("/updateOne")
    public String updateOne(User user){
        DB.update(user);
        return "forward:/selectAll" ;
    }
}
