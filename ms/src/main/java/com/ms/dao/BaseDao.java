package com.ms.dao;

import com.ms.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {
    protected  Connection connection = JdbcUtil.getConnection();
    protected PreparedStatement pStatement= null;
    protected void close(){
        try{
            this.connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
