/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2019.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2019/3/30    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/3/30 10:35
 */
public class TestShiro {
    public static void main(String[] args) {
        //用户
        User zhang3 = new User();
        zhang3.setName("zhang3");
        zhang3.setPassword("12345");

        User li4 = new User();
        li4.setName("li4");
        li4.setPassword("abcde");

        User wang5 = new User();
        wang5.setName("wang5");
        wang5.setPassword("wrongpassword");

        List<User> users = new ArrayList<>();

        users.add(zhang3);
        users.add(li4);
        users.add(wang5);
        //角色
        String roleAdmin = "admin";
        String roleProductManager ="productManager";

        List<String> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleProductManager);

        //权限
        String permitAddProduct = "addProduct";
        String permitAddOrder = "addOrder";

//        List<String> permits = new ArrayList<>();
//        permits.add(permitAddProduct);
//        permits.add(permitAddOrder);
//        System.out.println("-------登录验证------");
//        //登陆每个用户
//        for (User user : users) {
//            if(login(user)) {
//                System.out.printf("%s \t成功登陆，用的密码是 %s\t %n", user.getName(), user.getPassword());
//            }
//            else {
//                System.out.printf("%s \t成功失败，用的密码是 %s\t %n", user.getName(), user.getPassword());
//            }
//        }
//
//        System.out.println("-------角色验证------");
//
//        //判断能够登录的用户是否拥有某个角色
//        for (User user : users) {
//            for (String role : roles) {
//                if(login(user)) {
//                    if(hasRole(user, role)) {
//                        System.out.printf("%s\t 拥有角色: %s\t%n", user.getName(), role);
//                    }
//                    else {
//                        System.out.printf("%s\t 不拥有角色: %s\t%n", user.getName(), role);
//                    }
//                }
//            }
//        }
//        System.out.println("-------权限验证------");
//
//        //判断能够登录的用户，是否拥有某种权限
//        for (User user : users) {
//            for (String permit : permits) {
//                if(login(user)) {
//                    if(isPermitted(user, permit)) {
//                        System.out.printf("%s\t 拥有权限: %s\t%n", user.getName(), permit);
//                    }
//                    else {
//                        System.out.printf("%s\t 不拥有权限: %s\t%n", user.getName(), permit);
//                    }
//                }
//            }
//        }




        //新建用户
//        new ShiroDAO().createUser("tlw","123");

        User user = new User();
        user.setName("tlw");
        user.setPassword("123");

        if(login(user)){

            System.out.println("登录成功");
        }else{

            System.out.println("登录失败");
        }
    }

    private static boolean hasRole(User user, String role) {
        Subject subject = getSubject();
        return subject.hasRole(role);
    }

    private static boolean isPermitted(User user, String permit) {
        Subject subject = getSubject();
        return subject.isPermitted(permit);
    }


    /**
     * 需要优化
     * 这个Subject初始化应该放在最开始，不能每次调用都去读一次文件
     * @return
     */
    private static Subject getSubject() {
        //加载配置文件，并获取工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("F:\\idea-workspace\\demo\\src\\main\\java" +
                "\\shiro.ini");
        //获取安全管理者实例
        SecurityManager sm = factory.getInstance();
        //将安全管理者放入全局对象
        SecurityUtils.setSecurityManager(sm);
        //全局对象通过安全管理者生成Subject对象
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }

    private static boolean login(User user) {
        Subject subject= getSubject();
        //如果已经登录过了，退出 其实这里可以不用退出 但是很多人都是写的退出
        if(subject.isAuthenticated()) {
            subject.logout();
        }

        //封装用户的数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            //将用户的数据token 最终传递到Realm中进行对比
            subject.login(token);
        } catch (AuthenticationException e) {
            //验证错误
            return false;
        }
        return subject.isAuthenticated();
    }

}
