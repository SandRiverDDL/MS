package com.ms.dao;

import com.ms.util.JdbcUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    protected  Connection connection = JdbcUtil.getConnection();
    protected PreparedStatement pStatement= null;
    protected Statement statement=null;
    protected void close(){
        try{
            this.connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update(String sql,Object ...args) {
        try {
            this.pStatement =this.connection.prepareStatement(sql);

            /*
            /*填充占位符
             */
            for (int i = 0; i < args.length; i++) {
                this.pStatement.setObject(i + 1, args[i]);
            }
            //执行
            this.pStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
    }
    public  <T> List<T> getInstanceList(Class<T> tClass, String sql, Object...args){
        ResultSet rs =null;
        //创建集合对象
        ArrayList<T> list = new ArrayList<>();
        try{
            this.pStatement = this.connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                this.pStatement.setObject(i+1,args[i]);
            }
            //执行获取结果集
            rs = this.pStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                T t = tClass.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    /*获取列的列名,不推荐使用
                    /*String columnName = rsmd.getColumnName(i + 1);
                    /*获取列的别名
                    */
                    String columnLable = rsmd.getColumnLabel(i + 1);

                    //利用反射为每一个对象进行赋值操作赋值
                    Field field = tClass.getDeclaredField(columnLable);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                this.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

}
