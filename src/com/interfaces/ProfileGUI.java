package com.interfaces;

import com.database.DBConnect;
import com.university.Person;
import com.university.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfileGUI {
    private JPanel profilePanel;
    private JList subjectLabel;
    private JButton changeSubjectsButton;
    private JButton exitButton;
    private JButton OKButton;
    public JLabel nameLabel;
    public JLabel ageLabel;
    public JTextArea subjectList;
    private JLabel image;
    private JLabel imageLabel;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String role1,role2;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private JFrame frame=new JFrame();


    public ProfileGUI() {
//        changeSubjectsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SubjectGUI subjectGUI=new SubjectGUI();
//                try {
//
//                    subjectGUI.showSubjectGUI();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                } catch (ClassNotFoundException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                HomeGUI homeGUI=new HomeGUI();
                homeGUI.showHomeGUI();
            }
        });
        changeSubjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubjectGUI subjectGUI=new SubjectGUI();
                try {
                    subjectGUI.showSubjectGUI();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getProfilePanel() {
        return profilePanel;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void showProfile(String name,int age){
        image.setSize(50,80);
        frame.add(profilePanel);
        frame.setLocation(500,120);
        frame.setSize(625,620);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        nameLabel.setText(name);
        ageLabel.setText(String.valueOf(age));
        try {
            DBConnect dbConnect=new DBConnect();
            conn=dbConnect.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT A.subject_id,A.subject_code,A.subject_name FROM subject A," + role1 + " B," + role2 + " C Where B.id=" + id + " AND A.subject_id=C.subject_subject_id AND B.id=C." + role1 + "_" + role1 + "_id";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int subject_id = rs.getInt("subject_id");
                String subject_code = rs.getString("subject_code");
                String subject_name = rs.getString("subject_name");
                subjectList.append("    [" + subject_id + "] " + subject_code + " " + subject_name+"\n");
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Database is not Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        subjectList.setEditable(false);

    }

    private void createUIComponents() {

    }
}
