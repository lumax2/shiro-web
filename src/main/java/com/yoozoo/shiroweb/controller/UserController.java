package com.yoozoo.shiroweb.controller;

import com.yoozoo.shiroweb.model.form.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Hao on 2018/3/25.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request,Model model){

        //使用shiro的认证操作
        //1 获得Subject对象
        Subject subject = SecurityUtils.getSubject();

        //2 封装用户信息
        AuthenticationToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());

        //3 执行认证
        try{
            subject.login(token);
            User authenUser = (User) subject.getPrincipal();
            request.getSession().setAttribute("username",authenUser.getUsername());
            return "redirect:/index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户不存在");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
        }catch (Exception e){
            model.addAttribute("msg","系统异常");
        }
        return "login";
    }
}
