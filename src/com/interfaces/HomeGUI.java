package com.interfaces;

import com.university.Lecturer;
import com.university.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;

public class HomeGUI {
    private JPanel homePanel;
    private JButton exitButton;
    private JTabbedPane tabMenu;
    private JLabel titleLbl;
    private JPanel signinTab;
    private JPanel signupTab;
    private JTabbedPane tabbedPane2;
    private JTextField usernameStuField;
    private JButton signInStuBtn;
    private JPasswordField passwordStuField;
    private JButton selectSubjectsAndSignButton;
    private JButton clearButton;
    private JTextField nameTxt1;
    private JTextField ageTxt1;
    private JTextField usernameTxt1;
    private JPasswordField passwordTxt1;
    private JPasswordField passwordTxt2;
    private JPasswordField passwordTxt11;
    private JPasswordField passwordTxt21;
    private JTabbedPane tabbedPane1;
    private JButton signinLecBtn;
    private JTextField usernameLecField;
    private JPasswordField passwordLecField;
    private JButton signUpAndSelectButton;
    private JTextField nameTxt;
    private JTextField ageTxt;
    private JTextField usernameTxt;
    private JButton clearButton1;
    private JLabel nameStar;
    private JLabel ageStar;
    private JLabel usernameStar;
    private JLabel passwordStar21;
    private JLabel passwordStar2;
    private JLabel passwordStar1;
    private JLabel fillStar;
    private JLabel nameStar1;
    private JLabel ageStar1;
    private JLabel usernameStar1;
    private JLabel passwordStar11;

    private int ID;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private JFrame frame = new JFrame();


    public HomeGUI() {
        nameStar.setVisible(false);
        ageStar.setVisible(false);
        usernameStar.setVisible(false);
        passwordStar1.setVisible(false);
        passwordStar2.setVisible(false);
        nameStar1.setVisible(false);
        ageStar1.setVisible(false);
        usernameStar1.setVisible(false);
        passwordStar11.setVisible(false);
        passwordStar21.setVisible(false);
        signInStuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                ID = student.login_student(usernameStuField.getText(), passwordStuField.getText());

                if (ID == 0) {
                    JOptionPane.showMessageDialog(null, "Username or Password is incorrect!!!");
                    clearAllTxtBox();
                } else {
                    frame.dispose();
                    student.showPersonDetails(ID, student.role1, student.role2);

                }
            }
        });
        signinLecBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lecturer lecturer = new Lecturer();
                ID = lecturer.login_lecturer(usernameLecField.getText(), passwordLecField.getText());
                if (ID == 0) {
                    JOptionPane.showMessageDialog(null, "Username or Password is incorrect!!!");
                    clearAllTxtBox();
                } else {
                    frame.dispose();
                    lecturer.showPersonDetails(ID,lecturer.role1,lecturer.role2);
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
        signUpAndSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameTxt.getText().isEmpty() == true || ageTxt.getText().isEmpty() == true || usernameTxt.getText().isEmpty() == true || passwordTxt1.getText().isEmpty() == true || passwordTxt2.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "Please Fill all Fields!");
                } else {
                    if (passwordTxt1.getText().equals(passwordTxt2.getText())) {
                        Student student = new Student();
                        student.setName(nameTxt.getText());
                        student.setAge(Integer.parseInt(ageTxt.getText()));
                        student.setU_name(usernameTxt.getText());
                        student.setPassword(passwordTxt1.getText());
                        student.AddPersonData(student.role1, student.role2);
                        clearAllTxtBox();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match!");
                    }


                }

            }
        });
        nameTxt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (nameTxt.getText().isEmpty() == true) {
                    nameStar.setVisible(true);
                } else {
                    nameStar.setVisible(false);
                }

            }
        });
        nameTxt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                nameStar.setVisible(false);
            }
        });
        ageTxt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                ageStar.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (ageTxt.getText().isEmpty() == true) {
                    ageStar.setVisible(true);
                } else {
                    ageStar.setVisible(false);
                }
            }
        });
        usernameTxt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                usernameStar.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (usernameTxt.getText().isEmpty() == true) {
                    usernameStar.setVisible(true);
                } else {
                    usernameStar.setVisible(false);
                }
            }
        });
        passwordTxt1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                passwordStar1.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (passwordTxt1.getText().isEmpty() == true) {
                    passwordStar1.setVisible(true);
                } else {
                    passwordStar1.setVisible(false);
                }
            }
        });
        passwordTxt2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                passwordStar2.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (passwordTxt2.getText().isEmpty() == true) {
                    passwordStar2.setVisible(true);
                } else {
                    passwordStar2.setVisible(false);
                }
            }
        });
        nameTxt1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (nameTxt1.getText().isEmpty() == true) {
                    nameStar1.setVisible(true);
                } else {
                    nameStar1.setVisible(false);
                }

            }
        });
        nameTxt1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                nameStar1.setVisible(false);
            }
        });
        ageTxt1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                ageStar1.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (ageTxt1.getText().isEmpty() == true) {
                    ageStar1.setVisible(true);
                } else {
                    ageStar1.setVisible(false);
                }
            }
        });
        usernameTxt1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                usernameStar1.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (usernameTxt1.getText().isEmpty() == true) {
                    usernameStar1.setVisible(true);
                } else {
                    usernameStar1.setVisible(false);
                }
            }
        });
        passwordTxt11.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                passwordStar11.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (passwordTxt11.getText().isEmpty() == true) {
                    passwordStar11.setVisible(true);
                } else {
                    passwordStar11.setVisible(false);
                }
            }
        });
        passwordTxt21.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                passwordStar21.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (passwordTxt21.getText().isEmpty() == true) {
                    passwordStar21.setVisible(true);
                } else {
                    passwordStar21.setVisible(false);
                }
            }
        });

        selectSubjectsAndSignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameTxt1.getText().isEmpty() == true || ageTxt1.getText().isEmpty() == true || usernameTxt1.getText().isEmpty() == true || passwordTxt11.getText().isEmpty() == true || passwordTxt21.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "Please Fill all Fields!");
                } else {
                    if (passwordTxt1.getText().equals(passwordTxt2.getText())) {
                        Lecturer lecturer = new Lecturer();
                        lecturer.setName(nameTxt1.getText());
                        lecturer.setAge(Integer.parseInt(ageTxt1.getText()));
                        lecturer.setU_name(usernameTxt1.getText());
                        lecturer.setPassword(passwordTxt11.getText());
                        lecturer.AddPersonData(lecturer.role1, lecturer.role2);
                        clearAllTxtBox();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match!");
                    }


                }
            }
        });


        clearButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTxtBox();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTxtBox();
            }
        });
    }
    public void clearAllTxtBox(){
        nameTxt.setText(null);
        ageTxt.setText(null);
        usernameTxt.setText(null);
        passwordTxt1.setText(null);
        passwordTxt2.setText(null);
        nameTxt1.setText(null);
        ageTxt1.setText(null);
        usernameTxt1.setText(null);
        passwordTxt11.setText(null);
        passwordTxt21.setText(null);
        usernameStuField.setText(null);
        passwordStuField.setText(null);
        usernameLecField.setText(null);
        passwordLecField.setText(null);

    }


    public void showHomeGUI() {
        frame.add(homePanel);
        frame.setLocation(500, 120);
        frame.setSize(600, 420);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}