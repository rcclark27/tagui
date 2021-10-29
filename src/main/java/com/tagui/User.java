package com.tagui;

public class User
{

    private String firstName;
    private String lastName;
    private int userID;
    private String emailAddress;
    private String password;

    User() // default constructor
    {

    }

    User(String first, String last, int ID, String email, String passwd) // overloaded constructor
    {
        firstName = first;
        lastName = last;
        userID = ID;
        emailAddress = email;
        password = passwd;
    }

    public String getFirst()
    {
        return firstName;
    }

    public String getLast()
    {
        return lastName;
    }

    public int getUserID()
    {
        return userID;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getPassword()
    {
        return password;
    }

    public void setFirst(String first)
    {
        firstName = first;
    }

    public void setLast(String last)
    {
        lastName = last;
    }

    public void setEmailAddress(String email)
    {
        emailAddress = email;
    }

    public void setUserID(int ID)
    {
        userID = ID;
    }

    public void setPassword(String passwd)
    {
        password = passwd;
    }

}
