package com.myfirst.fashionbae.activities;

public class UserHelperClass {
    String firstName, lastName;


    public UserHelperClass() {
    }

    public UserHelperClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}

