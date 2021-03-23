package com.aifurion.blog.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.aifurion.blog.shiro.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：zzy
 * @description：TODO
 * @date ：2021/3/23 9:52
 */

@Configuration
public class ShiroConfig {


    /**
     *
     * 创建shiroFilter负责拦截请求
     *
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> map = new HashMap<>();

        /*
        排除
         */
        map.put("/user/login", "anon");
        map.put("/user/register", "anon");

        /*

        公开查看链接

        /view/author_name/page_id

         */
        map.put("/view/**","anon");
        map.put("/**", "authc");

        shiroFilterFactoryBean.setLoginUrl("/user/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;

    }


    /**
     *
     *创建安全管理器
     * 使用自定义realm
     * @param realm
     * @return
     */


    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("realm") Realm realm) {

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;

    }


    /**
     *
     * 创建自定义realm
     * @return
     */

    @Bean("realm")
    public Realm getRealm() {

        CustomRealm customRealm = new CustomRealm();


        /*

          修改默认凭证匹配器

         */

        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();


        /*

        MD5加密，迭代1024次

         */

        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        customRealm.setCredentialsMatcher(credentialsMatcher);
        return customRealm;

    }


    /**
     *
     * 添加thymeleaf对shiro的支持
     *
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {

        return new ShiroDialect();
    }




}
