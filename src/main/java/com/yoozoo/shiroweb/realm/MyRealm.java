package com.yoozoo.shiroweb.realm;

import com.yoozoo.shiroweb.model.form.User;
import com.yoozoo.shiroweb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Hao on 2018/3/25.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("正在执行授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /*1 基于资源的授权*/
        User userWithToken = (User) (SecurityUtils.getSubject().getPrincipal());
        List<String> perms =userService.findPermissionByUserId(userWithToken.getId());
        if(perms!=null){
            for(String perm:perms){
                info.addStringPermission(perm);
            }
        }
        /*2 基于角色的授权*/
        //info.addRole("admin");
        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("正在执行登录认证");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User dbUser =userService.findByName(token.getUsername());

        if(dbUser == null){
            return null;
        }

        return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),"");
    }

}
