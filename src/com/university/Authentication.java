package com.university;

import com.database.DBConnect;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Authentication {
    private String u_name;
    private String password;
    private String str_password;
    private int id;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public String getStr_password() {
        return str_password;
    }

    public void setStr_password(String str_password) {
        this.str_password = str_password;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int compareUsernamePassword(String username,String password,String role){
        Person person=new Person();
        try {
            DBConnect dbConnect=new DBConnect();
            conn=dbConnect.getConnection();
            stmt=conn.createStatement();
            String sql="SELECT id,name,password,age FROM "+role+" WHERE username='"+username+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                id=rs.getInt("id");
                person.setName(rs.getString("name"));
                setStr_password(rs.getString("password"));
                person.setAge(rs.getInt("age"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Database is not Connected!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Invalid SQL Expression");
        }
        if(password.equals(getStr_password())){
            return id;
        }
        else {
            return -1;
        }
    }
}
