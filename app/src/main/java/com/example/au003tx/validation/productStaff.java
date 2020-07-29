package com.example.au003tx.validation;

public class productStaff {

    private String name, role, email, phone, qualification, prmdno ;

    public productStaff(String name,String role,String phone,String email,String qualification,String prmdno )
    {
        this.name = name;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.prmdno = prmdno;

    }

    public String getName(){return name;}
    public String getRole(){return role;}
    public String getEmail(){return email;}
    public String getPhone(){return phone;}
    public String getQualification(){return qualification;}
    public String getPrmdno(){return prmdno;}
}
