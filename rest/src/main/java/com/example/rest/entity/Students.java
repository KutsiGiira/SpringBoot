package com.example.rest.entity;

public class Students {
    private String Fname;
    private String Lname;

    public Students(){

    }

    public Students(String F, String L){
        Fname = F;
        Lname = L;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getFname(){
        return Fname;
    }
    void setFname(String fn){
        Fname = fn;
    }
}
