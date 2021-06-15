package com.aifurion.track.shiro;


import com.aifurion.track.Utils.ApplicationContextUtils;
import com.aifurion.track.common.AjaxResult;
import com.aifurion.track.shiro.cache.RedisCacheManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * @author sujunxuan
 */
public class ShiroCacheHelper {


    /**
     * 私有构造器
     **/
    private ShiroCacheHelper() {
    }


    /**
     * @param loginId         用户的主身份信息，phone
     * @param isRemoveSession 是否删除session
     *                        true 删除
     *                        false 只查询状态，不删除
     * @author: zzy
     * @description: TODO 验证用户是否已经登录
     * @date: 2021/3/26 14:57
     */


    public static AjaxResult isOnline(String loginId, boolean isRemoveSession) {


        StringRedisTemplate redisTemplate = (StringRedisTemplate) ApplicationContextUtils.getBean("stringRedisTemplate");


        if (isRemoveSession) {


            redisTemplate.opsForHash().delete("authenticationCache", loginId);

            return AjaxResult.status("强制退出成功", 103);



        } else {


            Object sessionCache = redisTemplate.opsForHash().get("authenticationCache", loginId);


            /*
            sessionCache 为空则未登录
             */

            if (ObjectUtils.isEmpty(sessionCache)) {

               return AjaxResult.status("未登录", 101);

            } else {
               return AjaxResult.status("已登录", 102);

            }


        }





        /*//从缓存中获取Session
        Session session = null;
        Collection<Session> sessions = REDIS_SESSION_DAO.getActiveSessions();
        Object attribute = null;

        UserLoginInfo userLoginInfo;
        for (Session sessionInfo : sessions) {
            //遍历Session,找到该用户名称对应的Session
            attribute = sessionInfo.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            userLoginInfo = (UserLoginInfo) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (userLoginInfo == null) {
                continue;
            }
            if (Objects.equals(userLoginInfo.getLoginId(), loginId)) {
                session = sessionInfo;
                break;
            }
        }
        if (session == null) {
            return;
        }

        //删除session
        if (isRemoveSession) {
            REDIS_SESSION_DAO.delete(session);
        }

        //删除Cache，在访问受限接口时会重新授权
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authc = securityManager.getAuthenticator();
        ((LogoutAware) authc).onLogout((SimplePrincipalCollection) attribute);


        */


    }

}
