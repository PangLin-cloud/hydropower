package com.panglin.controller;

import com.panglin.pojo.TbUser;
import com.panglin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/21 17:48
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    public String login(){return "login";}

    @RequestMapping("/login.action")
    public String login(TbUser user, Model model, HttpSession session){
        List<TbUser> tbUsers = loginService.selectUserByPhoneAndPassword(user);
        if (tbUsers==null){
            session.setAttribute("message","用户名或密码错误");
            return "login";
        }else {
            if (tbUsers.get(0).getUserOrAdmin()==0){
                session.setAttribute("message","登录成功！");
                session.setAttribute("user",tbUsers.get(0));
                return "redirect:/admin.action";
            }else {
                session.setAttribute("message","登录成功！");
                session.setAttribute("user",tbUsers.get(0));
                return "redirect:/userIndex.action?id="+tbUsers.get(0).getId();
            }
        }
    }
}
