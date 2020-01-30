package com.university;

import com.database.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Subject {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String username;
    private int per_id;
    private String per_name;
    private int per_age;
    private String role1, role2;

    public String getPer_name() {
        return per_name;
    }

    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }

    public int getPer_age() {
        return per_age;
    }

    public void setPer_age(int per_age) {
        this.per_age = per_age;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2;
    }

    public String getUsername() {
        return username;
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void selectSubjects(int i) {
        try {
            DBConnect dbConnect = new DBConnect();
            conn = dbConnect.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT id FROM " + role1 + " WHERE username='" + username + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                per_id = rs.getInt("id");
            }
            sql = "INSERT INTO " + role2 + " VALUES (" + per_id + "," + (i + 1) + ")";
            stmt.executeUpdate(sql);
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException b) {
            b.printStackTrace();
        } catch (SQLException b) {
            b.printStackTrace();
        }
    }

    public void updateSubjects() {

    }
}
