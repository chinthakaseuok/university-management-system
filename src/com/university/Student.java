package com.university;

public class Student extends Person{
    private int compare;
    public String role1= "student",role2= "subject_has_student";


    public int login_student(String username, String password){
        compare=super.LoginPerson(username,password,role1);
        return compare;
    }

}
