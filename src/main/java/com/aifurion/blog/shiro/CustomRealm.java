package com.aifurion.blog.shiro;

import com.aifurion.blog.Utils.ApplicationContextUtils;
import com.aifurion.blog.entity.Permission;
import com.aifurion.blog.entity.User;
import com.aifurion.blog.salt.MyByteSource;
import com.aifurion.blog.service.AuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 10:03
 */

public class CustomRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        String principal = (String) principals.getPrimaryPrincipal();

        AuthService authService = (AuthService) ApplicationContextUtils.getBean("authServiceImpl");

        User user = authService.findRolesByUsername(principal);

        if (!CollectionUtils.isEmpty(user.getRoles())) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

            user.getRoles().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());

                List<Permission> permissions = authService.findPermissionByRoleId(role.getId());

                if (!CollectionUtils.isEmpty(permissions)) {

                    permissions.forEach(permission -> {

                        simpleAuthorizationInfo.addStringPermission(permission.getName());
                    });


                }


            });

            return simpleAuthorizationInfo;


        }


        return null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String principal = (String) token.getPrincipal();

        SimpleAuthenticationInfo simpleAuthenticationInfo = null;


        AuthService authService = (AuthService) ApplicationContextUtils.getBean("authServiceImpl");

        User user = authService.findUserByUsername(principal);

        if (!ObjectUtils.isEmpty(user)) {

            simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    principal,
                    user.getPassword(),
                    new MyByteSource(user.getSalt()),
                    this.getName());

        }


        return simpleAuthenticationInfo;
    }
}