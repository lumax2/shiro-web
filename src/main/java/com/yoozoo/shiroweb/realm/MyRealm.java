package com.yoozoo.shiroweb.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Hao on 2018/3/25.
 */
public class MyRealm extends AuthorizingRealm {

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("正在执行授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /*1 基于资源的授权*/
        info.addStringPermission("product:add");

        /*2 基于角色的授权*/
        info.addRole("admin");
        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("正在执行登录认证");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String usernameDatabase ="jack";
        String passwordDatebase ="123";

        if(!usernameDatabase.equals(token.getUsername())){
            //用户不存在
            return null;
        }
        return new SimpleAuthenticationInfo(usernameDatabase,passwordDatebase,"");
    }
}
