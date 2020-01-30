package com.university;

public class Lecturer extends Person {
    private int compare;
    public String role1="lecturer",role2="subject_has_lecturer";

    public int login_lecturer(String username,String password){
        compare=super.LoginPerson(username,password,role1);
        return compare;
    }

}
