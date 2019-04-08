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
 * 2019/3/31    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.jimi.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/3/31 12:10
 */
public class ShiroDAO {

    public ShiroDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shiro?characterEncoding=UTF-8", "root",
                "t199628");
    }

    public String getPassword(String userName) {
        String sql = "select password from user where name = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public Set<String> listRoles(String userName) {

        Set<String> roles = new HashSet<>();
        String sql = "select r.name from user u "
                + "left join user_role ur on u.id = ur.uid "
                + "left join Role r on r.id = ur.rid "
                + "where u.name = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                roles.add(rs.getString(1));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return roles;
    }

    public String createUser(String name, String password) {

        String sql = "insert into user values(null,?,?,?)";
        //加上随机数
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodedPassword= new SimpleHash("md5",password,salt,2).toString();

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, name);
            ps.setString(2, encodedPassword);
            ps.setString(3, salt);
            ps.execute();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;

    }

    public User getUser(String userName) {
        User user = null;
        String sql = "select * from user where name = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, userName);
//            System.out.println(ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setSalt(rs.getString("salt"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return user;
    }

    public Set<String> listPermissions(String userName) {
        Set<String> permissions = new HashSet<>();
        String sql =
                "select p.name from user u "+
                        "left join user_role ru on u.id = ru.uid "+
                        "left join role r on r.id = ru.rid "+
                        "left join role_permission rp on r.id = rp.rid "+
                        "left join permission p on p.id = rp.pid "+
                        "where u.name =?";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                permissions.add(rs.getString(1));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return permissions;
    }
    public static void main(String[] args) {
        System.out.println(new ShiroDAO().listRoles("zhang3"));
        System.out.println(new ShiroDAO().listRoles("li4"));
        System.out.println(new ShiroDAO().listPermissions("zhang3"));
        System.out.println(new ShiroDAO().listPermissions("li4"));
    }
}
