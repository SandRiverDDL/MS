package com.ms.dao;

import com.ms.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends BaseDao{
    public boolean selectUser(String username,String password) {
        String sql = "select* from user where username=? and password =?";
        try {
            this.pStatement = this.connection.prepareStatement(sql);
            this.pStatement.setString(1, username);
            this.pStatement.setString(2, password);

            ResultSet executeQuery = this.pStatement.executeQuery();
            if (executeQuery.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }
    public boolean selectUserByUsername(String username) {
        String sql = "select* from user where username=?";
        try {
            this.pStatement = this.connection.prepareStatement(sql);
            this.pStatement.setString(1, username);
            ResultSet executeQuery = this.pStatement.executeQuery();
            if (executeQuery.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }
    public boolean adduser(String username,String password) {
        String sql = "insert into user(username,password) values(?,?)";
        //获取预处理对象，并给参数赋值
        try {
            this.pStatement = this.connection.prepareStatement(sql);
            this.pStatement.setString(1, username);
            this.pStatement.setString(2, password);
            //执行sql语句（插入了几条记录，就返回几）
           this.pStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }

}
