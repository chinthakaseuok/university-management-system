package com.interfaces;

import com.database.DBConnect;
import com.university.Subject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class SubjectGUI {
    private JPanel subjectPanel;
    private JButton exitButton;
    private JLabel title;
    private JTable subjectTable;
    private JButton applyChangesButton;
    private ResultSet rs;
    private Statement stmt;
    private Connection conn;
    private JFrame frame=new JFrame();
    private String username;
    private int person_id;
    private String role1,role2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
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

    public void showSubjectGUI() throws SQLException, ClassNotFoundException {
        frame.add(subjectPanel);
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int col)
            { switch(col){
                case 0:
                    return false;
                case 1:
                    return false;
                case 2:
                    return true;
                default:
                    return false;
            } }
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return String.class;
                }

            }
        };

        subjectTable.setModel(model);


        model.addColumn("Subject Code");
        model.addColumn("Subject Name");
        model.addColumn("Enroll");
        DBConnect dbConnect=new DBConnect();
        conn=dbConnect.getConnection();
        stmt=conn.createStatement();
        String sqlQuery = "SELECT * FROM subject";
        rs=stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            String subject_code = rs.getString("subject_code");
            String subject_name = rs.getString("subject_name");
            boolean selection=false;
            model.addRow(new Object[]{subject_code,subject_name,selection});
        }
        dbConnect.closeConnection(rs,conn);
        subjectTable.setModel(model);
        subjectTable.setRowHeight(30);
        frame.setTitle("Subjects");
        frame.setUndecorated(true);
        frame.setSize(650, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public SubjectGUI() {
        applyChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean checked = null;
                int count=0;
                for(int i=0;i<subjectTable.getRowCount();i++)
                {
                    checked=Boolean.valueOf(subjectTable.getValueAt(i, 2).toString());


                    if(checked)
                    {
                        Subject subject=new Subject();
                        subject.setUsername(username);
                        subject.setRole1(role1);
                        subject.setRole2(role2);
                        subject.selectSubjects(i);
                        count++;
                    }

                   
                }
                if(count>0)
                {
                    JOptionPane.showMessageDialog(null,"Subjects Selected Successfully");
                    frame.dispose();
                    HomeGUI homeGUI=new HomeGUI();
                    homeGUI.clearAllTxtBox();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please Select a Subject!!!");
                }

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
    }

}
