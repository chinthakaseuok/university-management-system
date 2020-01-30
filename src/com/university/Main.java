package com.university;


import com.interfaces.HomeGUI;
import com.interfaces.ProfileGUI;
import com.interfaces.SubjectGUI;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HomeGUI homeGUI=new HomeGUI();
        homeGUI.showHomeGUI();
    }
}
