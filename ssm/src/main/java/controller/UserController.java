package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name="userService")
    private UserService us ;

    @RequestMapping("/toAddUserPage")
    public String toAddUserPage(){
        return "user/userEdit" ;
    }

    @RequestMapping(value = "/userSave",method = RequestMethod.POST)
    public String saveUser(User u){
        us.save(u);
        return "redirect:/user/findall" ;
    }

    /**
     * 删除用户
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("uid") Integer uid){
        us.delete(uid);
        return "redirect:/user/findall" ;
    }
    /**
     * 修改用户
     */
    @RequestMapping("/editUser")
    public String editUser(@RequestParam("uid") Integer uid, Model m){
        User user = us.selectOne(uid);
        m.addAttribute("user", user);
        return "/user/userEdit" ;
    }

    /**
     * 查看全部user
     */
    public String findAll(Model m){
        List<User> list = us.selectAll();
        m.addAttribute("allUsers",list);
        return "user/userList" ;
    }

    @RequestMapping(value = {"/findPage"})
    public String findPage(Model m ,@RequestParam("pn") int pn){
        //查询总记录数
        int counts = us.selectCount();

        //每页记录数
        int recordPerPage = 5 ;

        //结算页数
        int pages = 0 ;
        if(counts % recordPerPage == 0){
            pages = counts / recordPerPage ;
        }
        else{
            pages = counts / recordPerPage + 1;
        }

        //偏移量
        int offset = (pn - 1) * recordPerPage ;
        List<User> list = us.selectPage(offset, recordPerPage);
        m.addAttribute("allUsers", list);
        m.addAttribute("pages",pages) ;
        return "user/userList";
    }
    @RequestMapping(value = {"/findall"})
    public String findPage(Model m){
        //查询总记录数
        int counts = us.selectCount();

        //每页记录数
        int recordPerPage = 5 ;

        //结算页数
        int pages = 0 ;
        if(counts % recordPerPage == 0){
            pages = counts / recordPerPage ;
        }
        else{
            pages = counts / recordPerPage + 1;
        }

        //偏移量
        List<User> list = us.selectPage(0, recordPerPage);
        m.addAttribute("allUsers", list);
        m.addAttribute("pages",pages) ;
        return "user/userList";
    }
    @RequestMapping("/hello")
    public String accessHtml(){
        System.out.println("kkkk");
        return "forward:/html/hello.html" ;
    }

}
