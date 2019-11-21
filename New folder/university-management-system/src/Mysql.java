import java.sql.*;
public class Mysql {
    public static void main(String args[]){
        try{Class.forname("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");
    } catch (SQLException e) {
            e.printStackTrace();
        }


    }
