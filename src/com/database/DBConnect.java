package com.database;


import java.sql.*;

public class DBConnect {
    private String url="jdbc:mariadb://localhost:3306/university";
    private String user="root";
    private String pass="";
    private Connection conn;
    private Statement stat;
    private ResultSet resulset;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }

    public void insertData(String sqlQuery) throws SQLException {
        stat =conn.createStatement();
        stat.executeUpdate(sqlQuery);
    }

    public ResultSet getData(String sqlQuery) throws SQLException {
        Statement stmt = conn.createStatement();
        resulset = stmt.executeQuery(sqlQuery);
        return resulset;
    }




    public void closeConnection(ResultSet rs,Connection conn) throws SQLException {
        rs.close();
        conn.close();
    }

}
