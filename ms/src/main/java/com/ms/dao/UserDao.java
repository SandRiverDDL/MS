package com.ms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends BaseDao{
    public boolean selectuser(String username,String password){
        String sql = "select* from user where username=? and password =?";
        try{
            this.pStatement=this.connection.prepareStatement(sql);
            this.pStatement.setString(1,username);
            this.pStatement.setString(2,password);

            ResultSet executeQuery =this.pStatement.executeQuery();
            if(executeQuery.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return false;
    }


}
