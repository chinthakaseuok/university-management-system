package com.university;

import com.database.DBConnect;
import com.interfaces.ProfileGUI;
import com.interfaces.SubjectGUI;

import javax.swing.*;
import java.sql.*;

public class Person extends Authentication {
    private String name;
    private int age;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void AddPersonData(String role1, String role2) {
         try {
             DBConnect dbConnect=new DBConnect();
             conn=dbConnect.getConnection();
             stmt=conn.createStatement();
             String sql="INSERT INTO "+role1+" VALUES (NULL,'"+getName()+"',"+getAge()+", '"+ getU_name()+"', '"+getPassword()+"')";
             stmt.executeUpdate(sql);
             stmt.close();
             conn.close();
         }
         catch (ClassNotFoundException a) {
             a.printStackTrace();
         }
         catch (SQLException a) {
             a.printStackTrace();
         }
         SubjectGUI subjectGUI=new SubjectGUI();
         try {
            subjectGUI.setRole1(role1);
            subjectGUI.setRole2(role2);
            subjectGUI.setUsername(getU_name());
            subjectGUI.showSubjectGUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public int LoginPerson(String username,String password,String role1){
        int getID;
        getID=super.compareUsernamePassword(username,password,role1);
        if(getID==-1){
            return 0;
        }
        else{
            return getID;
        }
    }
     public void showPersonDetails(int id,String role1,String role2){
         try {
             DBConnect dbConnect=new DBConnect();
             conn=dbConnect.getConnection();
             stmt=conn.createStatement();
             String sql="SELECT name,age FROM "+role1+" WHERE id='"+id+"'";
             rs=stmt.executeQuery(sql);
             while (rs.next()){
                 name=rs.getString("name");
                 age=rs.getInt("age");
             }
             rs.close();
             stmt.close();
             conn.close();
         } catch (ClassNotFoundException e) {
             JOptionPane.showMessageDialog(null,"Database is not Connected!");
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Invalid SQL Expression");
         }
         ProfileGUI profileGUI=new ProfileGUI();
         profileGUI.setRole1(role1);
         profileGUI.setRole2(role2);
         profileGUI.setId(id);
         profileGUI.showProfile(name,age);
     }

}
